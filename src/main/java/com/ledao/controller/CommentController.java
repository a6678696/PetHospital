package com.ledao.controller;

import com.ledao.entity.*;
import com.ledao.service.*;
import com.ledao.util.PageUtil;
import com.ledao.util.StringUtil;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;
import java.util.Collections;
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
    private ReturnListGoodsService returnListGoodsService;

    @Resource
    private GoodsTypeService goodsTypeService;

    @Resource
    private CustomerService customerService;

    @Resource
    private FavoriteService favoriteService;

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
            comment.setSaleList(comment.getSaleListGoods().getSaleList());
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

    /**
     * 跳转到客户评价商品界面
     *
     * @param saleListGoodsId
     * @return
     */
    @RequestMapping("/commentPage")
    public ModelAndView commentPage(Integer saleListGoodsId) {
        ModelAndView mav = new ModelAndView();
        SaleListGoods saleListGoods = saleListGoodsService.findById(saleListGoodsId);
        Goods goods = goodsService.findById(saleListGoods.getGoodsId());
        mav.addObject("saleListGoods", saleListGoods);
        mav.addObject("goods", goods);
        mav.addObject("title", "评价商品");
        mav.addObject("mainPage", "page/comment/commentPage");
        mav.addObject("mainPageKey", "#b");
        mav.setViewName("index");
        return mav;
    }

    /**
     * 添加商品评价
     *
     * @param comment
     * @return
     */
    @RequestMapping("/save")
    public String save(Comment comment, HttpSession session) {
        Customer currentCustomer = (Customer) session.getAttribute("currentCustomer");
        comment.setCustomerId(currentCustomer.getId());
        commentService.add(comment);
        SaleListGoods saleListGoods = saleListGoodsService.findById(comment.getSaleListGoodsId());
        saleListGoods.setStatus(1);
        saleListGoodsService.update(saleListGoods);
        return "redirect:/comment/myComment/list/1";
    }

    /**
     * 查看评价详情
     *
     * @param commentId
     * @return
     */
    @RequestMapping("/commentDetails")
    public ModelAndView commentDetails(Integer commentId) {
        Comment comment = commentService.findById(commentId);
        comment.setGoods(goodsService.findById(comment.getGoodsId()));
        ModelAndView mav = new ModelAndView();
        mav.addObject("comment", comment);
        mav.addObject("title", "查看评价详情");
        mav.addObject("mainPage", "page/comment/commentDetails");
        mav.addObject("mainPageKey", "#b");
        mav.setViewName("index");
        return mav;
    }

    @RequestMapping("/customerComment/list/{id}")
    public ModelAndView customerComment(@PathVariable(value = "id", required = false) Integer page, Integer goodsId, HttpSession session) {
        ModelAndView mav = new ModelAndView();
        Map<String, Object> map = new HashMap<>(16);
        int pageSize = 4;
        map.put("start", (page - 1) * pageSize);
        map.put("size", pageSize);
        map.put("goodsId", goodsId);
        List<Comment> commentList = commentService.list(map);
        for (Comment comment : commentList) {
            comment.setCustomer(customerService.findById(comment.getCustomerId()));
        }
        Long total = commentService.getCount(map);
        List<GoodsType> goodsTypeList = goodsTypeService.findByParentId(1);
        for (GoodsType goodsType : goodsTypeList) {
            goodsType.setSmallGoodsTypeList(goodsTypeService.findByParentId(goodsType.getId()));
        }
        Map<String, Object> map2 = new HashMap<>(16);
        map.put("typeId", goodsService.findById(goodsId).getType().getId());
        List<Goods> goodsList = goodsService.list(map2);
        Collections.shuffle(goodsList);
        goodsList.remove(goodsService.findById(goodsId));
        Goods goods = goodsService.findById(goodsId);
        this.setGoodsFavorite(goods,session);
        mav.addObject("allSaleTotal", saleListGoodsService.getSaleCount(goods.getId()) - returnListGoodsService.getReturnCount(goods.getId()));
        mav.addObject("goodsTypeList", goodsTypeList);
        mav.addObject("goods", goods);
        mav.addObject("commentList", commentList);
        mav.addObject("recommendGoodsList", goodsList);
        mav.addObject("total", total);
        mav.addObject("pageCode", PageUtil.genPagination3("/comment/customerComment/list", total, page, pageSize,goodsId));
        mav.addObject("title", "客户评价");
        mav.addObject("mainPage", "page/comment/customerComment");
        mav.addObject("mainPageKey", "#b");
        mav.setViewName("index");
        return mav;
    }

    /**
     * 给商品设置是否已收藏标签(0否,1是)
     *
     * @param goods
     */
    private void setGoodsFavorite(Goods goods, HttpSession session) {
        Map<String, Object> map = new HashMap<>(16);
        map.put("customer", session.getAttribute("currentCustomer"));
        List<Favorite> favoriteList = favoriteService.list(map);
        for (Favorite favorite : favoriteList) {
            if (goods.getId().equals(favorite.getGoods().getId())) {
                goods.setIsFavorite(1);
            }
        }
    }
}
