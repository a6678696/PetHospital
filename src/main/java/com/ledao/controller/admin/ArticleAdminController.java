package com.ledao.controller.admin;

import com.ledao.entity.Article;
import com.ledao.entity.Log;
import com.ledao.entity.PageBean;
import com.ledao.run.StartupRunner;
import com.ledao.service.ArticleService;
import com.ledao.service.ArticleTypeService;
import com.ledao.service.LogService;
import com.ledao.util.DateUtil;
import com.ledao.util.StringUtil;
import org.apache.commons.io.FileUtils;
import org.apache.shiro.authz.annotation.Logical;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import javax.annotation.Resource;
import java.io.File;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 后台管理文章Controller层
 *
 * @author LeDao
 * @company
 * @create 2020-01-26 19:40
 */
@RestController
@RequestMapping("/admin/article")
public class ArticleAdminController {

    @Value("${articleImageFilePath}")
    private String articleImageFilePath;

    @Resource
    private ArticleService articleService;

    @Resource
    private ArticleTypeService articleTypeService;

    @Resource
    private LogService logService;

    @Resource
    private StartupRunner startupRunner;

    /**
     * 分页条件查询文章
     *
     * @param searchArticle
     * @param page
     * @param rows
     * @return
     */
    @RequestMapping("/list")
    @RequiresPermissions(value = "文章管理")
    public Map<String, Object> list(Article searchArticle, @RequestParam(value = "page", required = false) Integer page, @RequestParam(value = "rows", required = false) Integer rows) {
        PageBean pageBean = new PageBean(page, rows);
        Map<String, Object> resultMap = new HashMap<>(16);
        Map<String, Object> map = new HashMap<>(16);
        map.put("title", StringUtil.formatLike(searchArticle.getTitle()));
        map.put("typeId", searchArticle.getTypeId());
        map.put("start", pageBean.getStart());
        map.put("size", pageBean.getPageSize());
        List<Article> articleList=articleService.list(map);
        for (Article article : articleList) {
            article.setArticleType(articleTypeService.findById(article.getTypeId()));
        }
        resultMap.put("rows", articleList);
        resultMap.put("total", articleService.getCount(map));
        return resultMap;
    }

    /**
     * ckeditor上传图片
     *
     * @param file
     * @param CKEditorFuncNum
     * @return
     * @throws Exception
     */
    @RequestMapping("/ckeditorUpload")
    public String ckeditorUpload(@RequestParam("upload") MultipartFile file, String CKEditorFuncNum) throws Exception {
        // 获取文件名
        String fileName = file.getOriginalFilename();
        // 获取文件的后缀
        String suffixName = fileName.substring(fileName.lastIndexOf("."));
        String newFileName = DateUtil.getCurrentDateStr2() + suffixName;
        FileUtils.copyInputStreamToFile(file.getInputStream(), new File(articleImageFilePath + newFileName));

        StringBuffer sb = new StringBuffer();
        sb.append("<script type=\"text/javascript\">");
        sb.append("window.parent.CKEDITOR.tools.callFunction(" + CKEditorFuncNum + ",'" + "/static/images/articleImage/" + newFileName + "','')");
        sb.append("</script>");

        return sb.toString();
    }

    /**
     * 添加或修改文章
     *
     * @param article
     * @return
     */
    @RequestMapping("/save")
    @RequiresPermissions(value = {"文章管理","写文章","修改文章"},logical = Logical.OR)
    public Map<String, Object> save(Article article) {
        Map<String, Object> resultMap = new HashMap<>(16);
        int key;
        if (article.getId() == null) {
            logService.add(new Log(Log.ADD_ACTION, "添加文章" + article));
            key = articleService.add(article);
        } else {
            logService.add(new Log(Log.UPDATE_ACTION, "修改文章" + article));
            key = articleService.update(article);
        }
        if (key > 0) {
            resultMap.put("success", true);
            startupRunner.loadData();
        } else {
            resultMap.put("success", false);
        }
        return resultMap;
    }

    /**
     * 根据id删除文章,可批量删除
     *
     * @param ids
     * @return
     */
    @RequestMapping("/delete")
    @RequiresPermissions(value = "文章管理")
    public Map<String, Object> delete(String ids) {
        Map<String, Object> resultMap = new HashMap<>(16);
        String[] idsStr = ids.split(",");
        for (int i = 0; i < idsStr.length; i++) {
            int id = Integer.parseInt(idsStr[i]);
            logService.add(new Log(Log.DELETE_ACTION, "删除文章" + articleService.findById(id)));
            articleService.delete(id);
        }
        resultMap.put("success", true);
        startupRunner.loadData();
        return resultMap;
    }

    @RequestMapping("/findById")
    @RequiresPermissions(value = "文章管理")
    public Article findById(Integer id) {
        return articleService.findById(id);
    }
}
