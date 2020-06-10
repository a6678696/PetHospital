package com.ledao.controller;

import com.ledao.entity.Article;
import com.ledao.service.ArticleService;
import com.ledao.service.ArticleTypeService;
import com.ledao.util.PageUtil;
import com.ledao.util.StringUtil;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import javax.annotation.Resource;
import javax.validation.Valid;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author LeDao
 * @company
 * @create 2020-01-27 19:04
 */
@Controller
@RequestMapping("/article")
public class ArticleController {

    @Resource
    private ArticleService articleService;

    @Resource
    private ArticleTypeService articleTypeService;

    @RequestMapping("/search")
    public ModelAndView search(@Valid Article searchArticle, BindingResult bindingResult) {
        ModelAndView mav = new ModelAndView();
        if (bindingResult.hasErrors()) {
            mav.addObject("error", bindingResult.getFieldError().getDefaultMessage());
            mav.addObject("title", "首页");
            mav.addObject("mainPage", "page/indexFirst");
        } else {
            Map<String, Object> map = new HashMap<>(16);
            map.put("title", StringUtil.formatLike(searchArticle.getTitle()));
            List<Article> articleList = articleService.list(map);
            mav.addObject("articleList", articleList);
            mav.addObject("title", "关于(" + searchArticle.getTitle() + ")的文章");
            mav.addObject("mainPage", "page/article/articleResult");
            mav.addObject("mainPageKey", "#b");
            mav.addObject("searchArticle", searchArticle);
            mav.addObject("total", articleList.size());
        }
        mav.setViewName("index");
        return mav;
    }

    /**
     * 分页分类查询文章信息
     *
     * @param page
     * @param typeId
     * @return
     */
    @RequestMapping("/list/{id}")
    public ModelAndView list(@PathVariable(value = "id", required = false) Integer page, @RequestParam(value = "typeId", required = false) Integer typeId) {
        ModelAndView mav = new ModelAndView();
        Map<String, Object> map = new HashMap<>(16);
        String typeName = articleTypeService.findById(typeId).getName();
        map.put("typeId", typeId);
        int pageSize = 7;
        map.put("start", (page - 1) * pageSize);
        map.put("size", pageSize);
        List<Article> articleList = articleService.list(map);
        Long total = articleService.getCount(map);
        mav.addObject("typeName", typeName);
        mav.addObject("title", "文章列表(" + typeName + ")");
        mav.addObject("articleList", articleList);
        mav.addObject("total", total);
        mav.addObject("pageCode", PageUtil.genPagination("/article/list", total, page, pageSize, typeId));
        mav.addObject("mainPage", "page/article/articleList");
        mav.addObject("mainPageKey", "#b");
        mav.setViewName("index");
        return mav;
    }

    /**
     * 根据id获取文章详细信息
     *
     * @param id
     * @return
     */
    @RequestMapping("/{id}")
    public ModelAndView view(@PathVariable(value = "id", required = false) Integer id) {
        ModelAndView mav = new ModelAndView();
        Article article = articleService.findById(id);
        article.setClick(article.getClick()+1);
        articleService.update(article);
        mav.addObject("typeName", articleTypeService.findById(article.getTypeId()).getName());
        mav.addObject("article", article);
        mav.addObject("title", article.getTitle());
        mav.addObject("pageCode", this.getLastAndNextArticle(articleService.getLast(id), articleService.getNext(id)));
        mav.addObject("mainPage", "page/article/articleView");
        mav.addObject("mainPageKey", "#b");
        mav.setViewName("index");
        return mav;
    }

    /**
     * 获取上一篇文章和下一篇文章
     *
     * @param lastArticle
     * @param nextArticle
     * @return
     */
    private String getLastAndNextArticle(Article lastArticle, Article nextArticle) {
        StringBuffer pageCode = new StringBuffer();
        if (lastArticle == null || lastArticle.getId() == null) {
            pageCode.append("<p>上一篇:没有了</p>");
        } else {
            pageCode.append("<p>上一篇:<a href='/article/" + lastArticle.getId() + "'>" + lastArticle.getTitle() + "</a></p>");
        }
        if (nextArticle == null || nextArticle.getId() == null) {
            pageCode.append("<p>下一篇:没有了</p>");
        } else {
            pageCode.append("<p>下一篇:<a href='/article/" + nextArticle.getId() + "'>" + nextArticle.getTitle() + "</a></p>");
        }
        return pageCode.toString();
    }
}
