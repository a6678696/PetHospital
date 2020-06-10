package com.ledao.controller;

import com.ledao.entity.*;
import com.ledao.service.GoodsService;
import com.ledao.service.ReturnApplyService;
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
 * @author LeDao
 * @company
 * @create 2020-06-06 09:46
 */
@Controller
@RequestMapping("/returnApply")
public class ReturnApplyController {

    @Resource
    private ReturnApplyService returnApplyService;

    @Resource
    private GoodsService goodsService;

    @Resource
    private SaleListGoodsService saleListGoodsService;

    /**
     * 退货申请页面
     *
     * @param saleListGoodsId
     * @return
     */
    @RequestMapping("/returnApplyAdd")
    public ModelAndView returnApplyAdd(Integer saleListGoodsId) {
        ModelAndView mav = new ModelAndView();
        SaleListGoods saleListGoods = saleListGoodsService.findById(saleListGoodsId);
        saleListGoods.setCanReturnNum(saleListGoods.getNum() - saleListGoods.getReturnNum());
        saleListGoods.setGoods(goodsService.findById(saleListGoods.getGoodsId()));
        mav.addObject("saleListGoods", saleListGoods);
        mav.addObject("title", "退货申请");
        mav.addObject("mainPage", "page/returnApply/returnApplyAdd");
        mav.addObject("mainPageKey", "#b");
        mav.setViewName("index");
        return mav;
    }

    /**
     * 修改退货信息页面
     *
     * @param returnApplyId
     * @return
     */
    @RequestMapping("/returnApplyModify")
    public ModelAndView returnApplyModify(Integer returnApplyId) {
        ModelAndView mav = new ModelAndView();
        ReturnApply returnApply = returnApplyService.findById(returnApplyId);
        returnApply.setSaleListGoods(saleListGoodsService.findById(returnApply.getSaleListGoodsId()));
        returnApply.getSaleListGoods().setGoods(goodsService.findById(returnApply.getSaleListGoods().getGoodsId()));
        mav.addObject("key", 1);
        mav.addObject("returnApply", returnApply);
        mav.addObject("title", "退货信息修改");
        mav.addObject("mainPage", "page/returnApply/returnApplyModify");
        mav.addObject("mainPageKey", "#b");
        mav.setViewName("index");
        return mav;
    }

    /**
     * 添加或修改退货信息
     *
     * @param returnApply
     * @param session
     * @return
     */
    @RequestMapping("/save")
    public ModelAndView save(ReturnApply returnApply, HttpSession session) {
        ModelAndView mav = new ModelAndView("redirect:/returnApply/myReturnApply/list/1");
        Customer currentCustomer = (Customer) session.getAttribute("currentCustomer");
        returnApply.setCustomerId(currentCustomer.getId());
        if (returnApply.getId() == null) {
            returnApply.setCustomerId(currentCustomer.getId());
            returnApplyService.add(returnApply);
            SaleListGoods saleListGoods = saleListGoodsService.findById(returnApply.getSaleListGoodsId());
            saleListGoods.setReturnNum(returnApply.getNum());
            saleListGoods.setIsReturn(1);
            saleListGoodsService.update(saleListGoods);
        } else {
            SaleListGoods saleListGoods = saleListGoodsService.findById(returnApply.getSaleListGoodsId());
            saleListGoods.setReturnNum(returnApply.getNum());
            saleListGoodsService.update(saleListGoods);
            returnApplyService.update(returnApply);
        }
        return mav;
    }

    /**
     * 我的退货信息
     *
     * @return
     */
    @RequestMapping("/myReturnApply/list/{id}")
    public ModelAndView myReturnApply(@PathVariable(value = "id", required = false) Integer page, HttpSession session) {
        ModelAndView mav = new ModelAndView();
        Map<String, Object> map = new HashMap<>(16);
        int pageSize = 5;
        map.put("start", (page - 1) * pageSize);
        map.put("size", pageSize);
        Customer customer = (Customer) session.getAttribute("currentCustomer");
        map.put("customerId", customer.getId());
        List<ReturnApply> returnApplyList = returnApplyService.list(map);
        for (ReturnApply returnApply : returnApplyList) {
            returnApply.setSaleListGoods(saleListGoodsService.findById(returnApply.getSaleListGoodsId()));
        }
        Long total = returnApplyService.getCount(map);
        mav.addObject("returnApplyList", returnApplyList);
        mav.addObject("total", total);
        mav.addObject("pageCode", PageUtil.genPagination2("/returnApply/myReturnApply/list", total, page, pageSize));
        mav.addObject("title", "我的预约");
        mav.addObject("mainPage", "page/returnApply/myReturnApply");
        mav.addObject("mainPageKey", "#b");
        mav.setViewName("index");
        return mav;
    }

    /**
     * 客户参考退货信息详情
     *
     * @param returnApplyId
     * @return
     */
    @RequestMapping("/returnApplyDetails")
    public ModelAndView returnApplyDetails(Integer returnApplyId) {
        ModelAndView mav = new ModelAndView();
        ReturnApply returnApply = returnApplyService.findById(returnApplyId);
        returnApply.setSaleListGoods(saleListGoodsService.findById(returnApply.getSaleListGoodsId()));
        returnApply.getSaleListGoods().setGoods(goodsService.findById(returnApply.getSaleListGoods().getGoodsId()));
        mav.addObject("returnApply", returnApply);
        mav.addObject("title", "退货信息详情");
        mav.addObject("mainPage", "page/returnApply/returnApplyDetails");
        mav.addObject("mainPageKey", "#b");
        mav.setViewName("index");
        return mav;
    }

    /**
     * 删除退货申请信息(取消退货申请)
     *
     * @param returnApplyId
     * @return
     */
    @RequestMapping("/delete")
    public String delete(Integer returnApplyId) {
        ReturnApply returnApply = returnApplyService.findById(returnApplyId);
        SaleListGoods saleListGoods = saleListGoodsService.findById(returnApply.getSaleListGoodsId());
        saleListGoods.setIsReturn(0);
        saleListGoods.setReturnNum(0);
        saleListGoodsService.update(saleListGoods);
        returnApplyService.delete(returnApplyId);
        return "redirect:/returnApply/myReturnApply/list/1";
    }
}
