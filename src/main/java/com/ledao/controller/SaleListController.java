package com.ledao.controller;

import com.ledao.entity.Customer;
import com.ledao.entity.Goods;
import com.ledao.entity.SaleList;
import com.ledao.entity.SaleListGoods;
import com.ledao.service.GoodsService;
import com.ledao.service.SaleListGoodsService;
import com.ledao.service.SaleListService;
import com.ledao.util.PageUtil;
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
 * 客户订单Controller层
 *
 * @author LeDao
 * @company
 * @create 2020-04-30 23:04
 */
@Controller
@RequestMapping("/saleList")
public class SaleListController {

    @Resource
    private SaleListService saleListService;

    @Resource
    private SaleListGoodsService saleListGoodsService;

    @Resource
    private GoodsService goodsService;

    /**
     * 我的订单
     *
     * @param page
     * @param session
     * @return
     */
    @RequestMapping("/mySaleList/list/{id}")
    public ModelAndView mySaleList(@PathVariable(value = "id", required = false) Integer page, HttpSession session) {
        ModelAndView mav = new ModelAndView();
        Map<String, Object> map = new HashMap<>(16);
        int pageSize = 3;
        map.put("start", (page - 1) * pageSize);
        map.put("size", pageSize);
        Customer currentCustomer = (Customer) session.getAttribute("currentCustomer");
        map.put("customer", currentCustomer);
        List<SaleList> mySaleListList = saleListService.list(map);
        Long total = saleListService.getCount(map);
        mav.addObject("mySaleListList", mySaleListList);
        mav.addObject("total", total);
        mav.addObject("pageCode", PageUtil.genPagination2("/saleList/mySaleList/list", total, page, pageSize));
        mav.addObject("title", "我的订单");
        mav.addObject("mainPage", "page/customer/mySaleList");
        mav.addObject("mainPageKey", "#b");
        mav.setViewName("index");
        return mav;
    }

    /**
     * 查看订单详情
     *
     * @param saleListId
     * @return
     */
    @RequestMapping("/mySaleListDetails")
    public ModelAndView mySaleListDetails(Integer saleListId) {
        ModelAndView mav = new ModelAndView();
        SaleList saleList = saleListService.findById(saleListId);
        Map<String, Object> map = new HashMap<>(16);
        map.put("saleListId", saleList.getId());
        saleList.setSaleListGoodsList(saleListGoodsService.list(map));
        for (SaleListGoods saleListGoods : saleList.getSaleListGoodsList()) {
            saleListGoods.setGoods(goodsService.findById(saleListGoods.getGoodsId()));
        }
        mav.addObject("saleList", saleList);
        mav.addObject("title", "查看订单详情");
        mav.addObject("mainPage", "page/saleList/mySaleListDetails");
        mav.addObject("mainPageKey", "#b");
        mav.setViewName("index");
        return mav;
    }

    /**
     * 客户取消未发货的订单
     *
     * @param saleListId
     * @return
     */
    @RequestMapping("/cancelOrder")
    public String cancelOrder(Integer saleListId) {
        SaleList saleList = saleListService.findById(saleListId);
        Map<String,Object> map=new HashMap<>(16);
        map.put("saleListId", saleListId);
        List<SaleListGoods> saleListGoodsList = saleListGoodsService.list(map);
        for (SaleListGoods saleListGoods : saleListGoodsList) {
            Goods goods = goodsService.findById(saleListGoods.getGoodsId());
            goods.setInventoryQuantity(goods.getInventoryQuantity()+saleListGoods.getNum());
            goodsService.update(goods);
        }
        saleList.setState(6);
        saleListService.update(saleList);
        return "redirect:/saleList/mySaleListDetails" + "?saleListId=" + saleListId;
    }

    /**
     * 客户确认收货
     *
     * @param saleListId
     * @return
     */
    @RequestMapping("/confirmDispatch")
    public String confirmDispatch(Integer saleListId) {
        SaleList saleList = saleListService.findById(saleListId);
        saleList.setState(5);
        saleListService.update(saleList);
        return "redirect:/saleList/mySaleListDetails" + "?saleListId=" + saleListId;
    }

    /**
     * 查看订单详情
     *
     * @param saleListId
     * @return
     */
    @RequestMapping("/payPage")
    public ModelAndView payPage(Integer saleListId) {
        ModelAndView mav = new ModelAndView();
        SaleList saleList = saleListService.findById(saleListId);
        Map<String, Object> map = new HashMap<>(16);
        map.put("saleListId", saleList.getId());
        saleList.setSaleListGoodsList(saleListGoodsService.list(map));
        for (SaleListGoods saleListGoods : saleList.getSaleListGoodsList()) {
            saleListGoods.setGoods(goodsService.findById(saleListGoods.getGoodsId()));
        }
        mav.addObject("saleList", saleList);
        mav.addObject("title", "支付订单");
        mav.addObject("mainPage", "page/saleList/payPage");
        mav.addObject("mainPageKey", "#b");
        mav.setViewName("index");
        return mav;
    }
}
