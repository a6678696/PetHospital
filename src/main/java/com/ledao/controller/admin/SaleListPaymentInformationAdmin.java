package com.ledao.controller.admin;

import com.ledao.entity.Customer;
import com.ledao.entity.Log;
import com.ledao.entity.PageBean;
import com.ledao.entity.SaleListPaymentInformation;
import com.ledao.service.CustomerService;
import com.ledao.service.LogService;
import com.ledao.service.SaleListPaymentInformationService;
import com.ledao.util.StringUtil;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 后台客户支付管理Controller层
 *
 * @author LeDao
 * @company
 * @create 2020-05-24 20:25
 */
@RestController
@RequestMapping("/admin/saleListPaymentInformation")
public class SaleListPaymentInformationAdmin {

    @Resource
    private SaleListPaymentInformationService saleListPaymentInformationService;

    @Resource
    private CustomerService customerService;

    @Resource
    private LogService logService;

    @InitBinder
    public void initBinder(WebDataBinder binder) {
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        dateFormat.setLenient(true);
        //true:允许输入空值，false:不能为空值
        binder.registerCustomEditor(Date.class, new CustomDateEditor(dateFormat, true));
    }

    @RequestMapping("/list")
    @RequiresPermissions(value = "客户支付记录管理")
    public Map<String, Object> list(SaleListPaymentInformation saleListPaymentInformation, @RequestParam(value = "page", required = false) Integer page, @RequestParam(value = "rows", required = false) Integer rows) {
        PageBean pageBean = new PageBean(page, rows);
        Map<String,Object> resultMap=new HashMap<>(16);
        Map<String,Object> map=new HashMap<>(16);
        map.put("type", saleListPaymentInformation.getType());
        if (saleListPaymentInformation.getCustomer() != null) {
            map.put("customerId", saleListPaymentInformation.getCustomer().getId());
        }
        map.put("saleNumber", StringUtil.formatLike(saleListPaymentInformation.getSaleNumber()));
        map.put("bSaleDate", saleListPaymentInformation.getbSaleDate());
        map.put("eSaleDate", saleListPaymentInformation.geteSaleDate());
        map.put("start", pageBean.getStart());
        map.put("size", pageBean.getPageSize());
        List<SaleListPaymentInformation> saleListPaymentInformationList = saleListPaymentInformationService.list(map);
        for (SaleListPaymentInformation listPaymentInformation : saleListPaymentInformationList) {
            Customer customer = customerService.findById(listPaymentInformation.getCustomerId());
            listPaymentInformation.setCustomer(customer);
        }
        Long total = saleListPaymentInformationService.getCount(map);
        resultMap.put("rows", saleListPaymentInformationList);
        resultMap.put("total", total);
        logService.add(new Log(Log.SEARCH_ACTION, "查询客户支付记录"));
        return resultMap;
    }
}
