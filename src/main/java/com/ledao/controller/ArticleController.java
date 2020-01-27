package com.ledao.controller;

import com.ledao.entity.Article;
import com.ledao.service.ArticleService;
import com.ledao.util.PageUtil;
import com.ledao.util.StringUtil;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import javax.annotation.Resource;
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

    @RequestMapping("/list/{id}")
    public ModelAndView list(@PathVariable(value = "id", required = false) Integer page, @RequestParam(value = "type", required = false) String type, @RequestParam(value = "typeName",required = false) String typeName) {
        ModelAndView mav = new ModelAndView();
        Map<String, Object> map = new HashMap<>(16);
        int ArticleType = 0;
        if (StringUtil.isNotEmpty(typeName)) {
            if ("医院公告".equals(typeName)) {
                ArticleType = 1;
            } else if ("医院新闻".equals(typeName)) {
                ArticleType = 2;
            } else if ("宠物大全".equals(typeName)) {
                ArticleType = 3;
            } else if ("用药常识".equals(typeName)) {
                ArticleType = 4;
            }
            map.put("type", ArticleType);
            mav.addObject("typeName", typeName);
            mav.addObject("title", "文章列表("+typeName+")");
        } else {
            String typeName2 = null;
            if (Integer.parseInt(type) == 1) {
                typeName2 = "医院公告";
            } else if (Integer.parseInt(type) == 2) {
                typeName2 = "医院新闻";
            } else if (Integer.parseInt(type) == 3) {
                typeName2 = "宠物大全";
            } else if (Integer.parseInt(type) == 4) {
                typeName2 = "用药常识";
            }
            map.put("type", Integer.parseInt(type));
            mav.addObject("typeName", typeName2);
            mav.addObject("title", "文章列表("+typeName2+")");
        }
        int pageSize=5;
        map.put("start", (page - 1)*pageSize);
        map.put("size", pageSize);
        List<Article> articleList = articleService.list(map);
        Long total = articleService.getCount(map);
        mav.addObject("articleList", articleList);
        mav.addObject("total", total);
        mav.addObject("pageCode", PageUtil.genPagination("/article/list", total, page, pageSize,ArticleType == 0?(Integer.parseInt(type)):ArticleType));
        mav.addObject("mainPage", "page/articleList");
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
        article.setClick(article.getClick() + 1);
        articleService.update(article);
        String typeName = null;
        if (article.getType() == 1) {
            typeName = "医院公告";
        } else if (article.getType() == 2) {
            typeName = "医院新闻";
        } else if (article.getType() == 3) {
            typeName = "宠物大全";
        } else if (article.getType() == 4) {
            typeName = "用药常识";
        }
        mav.addObject("typeName", typeName);
        mav.addObject("article", article);
        mav.addObject("title", article.getTitle());
        mav.addObject("pageCode", this.getLastAndNextArticle(articleService.getLast(id), articleService.getNext(id)));
        mav.addObject("mainPage", "page/articleView");
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
