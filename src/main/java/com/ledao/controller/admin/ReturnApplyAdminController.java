package com.ledao.controller.admin;

import com.ledao.entity.*;
import com.ledao.service.CustomerService;
import com.ledao.service.LogService;
import com.ledao.service.ReturnApplyService;
import com.ledao.service.SaleListGoodsService;
import com.ledao.util.StringUtil;
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
 * 后台管理客户退货申请Controller层
 *
 * @author LeDao
 * @company
 * @create 2020-06-11 10:12
 */
@RestController
@RequestMapping("/admin/returnApply")
public class ReturnApplyAdminController {

    @Resource
    private ReturnApplyService returnApplyService;

    @Resource
    private CustomerService customerService;

    @Resource
    private SaleListGoodsService saleListGoodsService;

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
    public Map<String, Object> list(ReturnApply returnApply, @RequestParam(value = "page", required = false) Integer page, @RequestParam(value = "rows", required = false) Integer rows) {
        PageBean pageBean = new PageBean(page, rows);
        Map<String, Object> resultMap = new HashMap<>(16);
        Map<String, Object> map = new HashMap<>(16);
        map.put("saleListNumber", StringUtil.formatLike(returnApply.getSaleListNumber()));
        map.put("customerId", returnApply.getCustomerId());
        map.put("status", returnApply.getStatus());
        map.put("bSaleDate", returnApply.getbSaleDate());
        map.put("eSaleDate", returnApply.geteSaleDate());
        map.put("start", pageBean.getStart());
        map.put("size", pageBean.getPageSize());
        List<ReturnApply> returnApplyList = returnApplyService.list(map);
        for (ReturnApply returnApply1 : returnApplyList) {
            returnApply1.setCustomer(customerService.findById(returnApply1.getCustomerId()));
        }
        resultMap.put("rows", returnApplyList);
        resultMap.put("total", returnApplyService.getCount(map));
        logService.add(new Log(Log.SEARCH_ACTION, "查询文章类型"));
        return resultMap;
    }

    /**
     * 修改退货申请信息的状态
     *
     * @param id
     * @param status
     * @return
     */
    @RequestMapping("/handleReturnApply")
    public Map<String, Object> handleReturnApply(Integer id, Integer status) {
        Map<String, Object> resultMap = new HashMap<>(16);
        ReturnApply returnApply = returnApplyService.findById(id);
        /*if (returnApply.getStatus()==2) {
            resultMap.put("errorInfo", "该订单已被取消,不能操作!");
            return resultMap;
        }*/
        returnApply.setStatus(status);
        int ReturnApplyStatus = 2;
        if (status == ReturnApplyStatus) {
            SaleListGoods saleListGoods = saleListGoodsService.findById(returnApply.getSaleListGoodsId());
            saleListGoods.setReturnNum(0);
            saleListGoodsService.update(saleListGoods);
        }
        returnApplyService.update(returnApply);
        resultMap.put("success", true);
        return resultMap;
    }
}
