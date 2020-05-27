package com.ledao.controller;

import com.ledao.entity.Comment;
import com.ledao.entity.Customer;
import com.ledao.entity.SaleListGoods;
import com.ledao.service.CommentService;
import com.ledao.service.GoodsService;
import com.ledao.service.SaleListGoodsService;
import com.ledao.service.SaleListService;
import com.ledao.util.PageUtil;
import com.ledao.util.StringUtil;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 前台客户商品评论Controller层
 *
 * @author LeDao
 * @company
 * @create 2020-05-27 23:04
 */
@Controller
@RequestMapping("/comment")
public class CommentController {

    @Resource
    private CommentService commentService;

    @Resource
    private GoodsService goodsService;

    @Resource
    private SaleListGoodsService saleListGoodsService;

    @Resource
    private SaleListService saleListService;

    /**
     * 我的化验记录
     *
     * @param page
     * @param session
     * @return
     */
    @RequestMapping("/myComment/list/{id}")
    public ModelAndView myComment(@PathVariable(value = "id", required = false) Integer page, HttpSession session) {
        ModelAndView mav = new ModelAndView();
        Map<String, Object> map = new HashMap<>(16);
        int pageSize = 4;
        map.put("start", (page - 1) * pageSize);
        map.put("size", pageSize);
        Customer currentCustomer = (Customer) session.getAttribute("currentCustomer");
        map.put("customerId", currentCustomer.getId());
        List<Comment> commentList = commentService.list(map);
        for (Comment comment : commentList) {
            comment.setGoods(goodsService.findById(comment.getGoodsId()));
            comment.setSaleListGoods(saleListGoodsService.findById(comment.getSaleListGoodsId()));
            comment.setSaleList(saleListService.findById(comment.getSaleListGoods().getSaleListId()));
        }
        Long total = commentService.getCount(map);
        mav.addObject("commentList", commentList);
        mav.addObject("total", total);
        mav.addObject("pageCode", PageUtil.genPagination2("/comment/myComment/list", total, page, pageSize));
        mav.addObject("title", "我的评论");
        mav.addObject("mainPage", "page/comment/myComment");
        mav.addObject("mainPageKey", "#b");
        mav.setViewName("index");
        return mav;
    }

    @RequestMapping("/commentPage")
    public ModelAndView commentPage() {
        ModelAndView mav = new ModelAndView();
        mav.addObject("title", "评价商品");
        mav.addObject("mainPage", "page/comment/commentPage");
        mav.addObject("mainPageKey", "#b");
        mav.setViewName("index");
        return mav;
    }

}
