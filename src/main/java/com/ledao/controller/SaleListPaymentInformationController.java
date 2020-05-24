package com.ledao.controller;

import com.ledao.entity.*;
import com.ledao.service.SaleListPaymentInformationService;
import com.ledao.service.SaleListService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 前台客户支付记录Controller层
 *
 * @author LeDao
 * @company
 * @create 2020-05-22 14:50
 */
@Controller
@RequestMapping("/saleListPaymentInformation")
public class SaleListPaymentInformationController {

    @Resource
    private SaleListPaymentInformationService saleListPaymentInformationService;

    @Resource
    private SaleListService saleListService;

    /**
     * 客户支付订单
     *
     * @param saleListPaymentInformation
     * @param session
     * @return
     */
    @RequestMapping("/pay")
    public String pay(SaleListPaymentInformation saleListPaymentInformation, HttpSession session) {
        Customer customer = (Customer) session.getAttribute("currentCustomer");
        SaleList saleList = saleListService.findBySaleNumber(saleListPaymentInformation.getSaleNumber());
        saleList.setRemarks(saleListPaymentInformation.getRemark());
        saleList.setState(1);
        saleListService.update(saleList);
        saleListPaymentInformation.setCustomerId(customer.getId());
        saleListPaymentInformationService.add(saleListPaymentInformation);
        return "redirect:/saleList/mySaleListDetails" + "?saleListId=" + saleList.getId();
    }
}
