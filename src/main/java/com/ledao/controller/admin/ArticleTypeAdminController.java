package com.ledao.controller.admin;

import com.ledao.entity.*;
import com.ledao.run.StartupRunner;
import com.ledao.service.ArticleService;
import com.ledao.service.ArticleTypeService;
import com.ledao.service.LogService;
import com.ledao.util.StringUtil;
import org.apache.shiro.authz.annotation.Logical;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 后台管理文章类型Controller层
 *
 * @author LeDao
 * @company
 * @create 2020-01-28 15:48
 */
@RestController
@RequestMapping("/admin/articleType")
public class ArticleTypeAdminController {

    @Resource
    private ArticleTypeService articleTypeService;

    @Resource
    private ArticleService articleService;

    @Resource
    private LogService logService;

    @Resource
    private StartupRunner startupRunner;

    /**
     * 下拉框模糊查询
     *
     * @param q
     * @return
     */
    @RequestMapping("/comboList")
    @RequiresPermissions(value = {"写文章", "文章管理"}, logical = Logical.OR)
    public List<ArticleType> comboList(String q) {
        if (q == null) {
            q = "";
        }
        return articleTypeService.findByName(StringUtil.formatLike(q));
    }

    /**
     * 分页分条件查询文章类型
     *
     * @param articleType
     * @param page
     * @param rows
     * @return
     */
    @RequestMapping("/list")
    @RequiresPermissions(value = {"文章类别管理", "写文章"}, logical = Logical.OR)
    public Map<String, Object> list(ArticleType articleType, @RequestParam(value = "page", required = false) Integer page, @RequestParam(value = "rows", required = false) Integer rows) {
        PageBean pageBean = new PageBean(page, rows);
        Map<String, Object> resultMap = new HashMap<>(16);
        Map<String, Object> map = new HashMap<>(16);
        map.put("name", StringUtil.formatLike(articleType.getName()));
        map.put("start", pageBean.getStart());
        map.put("size", pageBean.getPageSize());
        List<ArticleType> articleTypeList = articleTypeService.list(map);
        Long total = articleTypeService.getCount(map);
        resultMap.put("rows", articleTypeList);
        resultMap.put("total", total);
        logService.add(new Log(Log.SEARCH_ACTION, "查询文章类型"));
        return resultMap;
    }

    /**
     * 添加或修改文章类型
     *
     * @param articleType
     * @return
     */
    @RequestMapping("/save")
    @RequiresPermissions(value = "文章类型管理")
    public Map<String, Object> save(ArticleType articleType){
        Map<String, Object> resultMap = new HashMap<>(16);
        int key;
        if (articleType.getId() == null) {
            logService.add(new Log(Log.ADD_ACTION, "添加文章类型" + articleType));
            key = articleTypeService.add(articleType);
        } else {
            logService.add(new Log(Log.UPDATE_ACTION, "修改文章类型" + articleType));
            key = articleTypeService.update(articleType);
        }
        if (key > 0) {
            startupRunner.loadData();
            resultMap.put("success", true);
        } else {
            resultMap.put("success", false);
        }
        return resultMap;
    }

    /**
     * 删除文章类型,可批量删除
     *
     * @param ids
     * @return
     */
    @RequestMapping("/delete")
    @RequiresPermissions(value = "文章类型管理")
    public Map<String, Object> delete(String ids){
        Map<String, Object> resultMap = new HashMap<>(16);
        String[] idsStr = ids.split(",");
        for (int i = 0; i < idsStr.length; i++) {
            int id = Integer.parseInt(idsStr[i]);
            List<Article> articleList = articleService.findByTypeId(id);
            if (articleList.size() > 0) {
                resultMap.put("errorInfo", "您要删除的文章类型下有" + articleList.size() + "篇文章,不能删除!");
                return resultMap;
            } else {
                logService.add(new Log(Log.DELETE_ACTION, "删除文章类型" + articleTypeService.findById(id)));
                articleTypeService.delete(id);
            }
        }
        startupRunner.loadData();
        resultMap.put("success", true);
        return resultMap;
    }
}
