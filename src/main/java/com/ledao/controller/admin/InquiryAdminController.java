package com.ledao.controller.admin;

import com.ledao.entity.*;
import com.ledao.service.CustomerService;
import com.ledao.service.InquiryService;
import com.ledao.service.LogService;
import com.ledao.util.StringUtil;
import org.apache.commons.io.FileUtils;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;
import java.io.File;
import java.util.HashMap;
import java.util.Map;

/**
 * @author LeDao
 * @company
 * @create 2020-03-16 13:43
 */
@RestController
@RequestMapping("/admin/inquiry")
public class InquiryAdminController {

    @Value("${inquiryImageFilePath}")
    private String inquiryImageFilePath;

    @Resource
    private InquiryService inquiryService;

    @Resource
    private CustomerService customerService;

    @Resource
    private LogService logService;

    /**
     * 查看未答复的客户网上问诊
     *
     * @param inquiry
     * @param page
     * @param rows
     * @return
     */
    @RequestMapping("/listWebInquiry")
    @RequiresPermissions(value = "网上问诊")
    public Map<String, Object> listWebInquiry(Inquiry inquiry, @RequestParam(value = "page", required = false) Integer page, @RequestParam(value = "rows", required = false) Integer rows) {
        PageBean pageBean = new PageBean(page, rows);
        Map<String, Object> resultMap = new HashMap<>(16);
        Map<String, Object> map = new HashMap<>(16);
        if (inquiry.getCustomer() != null) {
            if (!StringUtil.isEmpty(inquiry.getCustomer().getContact())) {
                Customer customer = customerService.findByContact(inquiry.getCustomer().getContact());
                if (customer != null) {
                    int customerId = customer.getId();
                    map.put("customerId", customerId);
                } else {
                    map.put("customerId", -1);
                }
            }
        }
        map.put("status", 0);
        map.put("start", pageBean.getStart());
        map.put("size", pageBean.getPageSize());
        resultMap.put("rows", inquiryService.list(map));
        resultMap.put("total", inquiryService.getCount(map));
        logService.add(new Log(Log.SEARCH_ACTION, "查看未答复的客户网上问诊"));
        return resultMap;
    }

    /**
     * 查看当前登录的医生答复的客户网上问诊
     *
     * @param inquiry
     * @param page
     * @param rows
     * @return
     */
    @RequestMapping("/myInquiryAnswer")
    @RequiresPermissions(value = "我的问诊")
    public Map<String, Object> myInquiryAnswer(Inquiry inquiry, @RequestParam(value = "page", required = false) Integer page, @RequestParam(value = "rows", required = false) Integer rows,HttpSession session) {
        PageBean pageBean = new PageBean(page, rows);
        Map<String, Object> resultMap = new HashMap<>(16);
        Map<String, Object> map = new HashMap<>(16);
        if (inquiry.getCustomer() != null) {
            if (!StringUtil.isEmpty(inquiry.getCustomer().getContact())) {
                Customer customer = customerService.findByContact(inquiry.getCustomer().getContact());
                if (customer != null) {
                    int customerId = customer.getId();
                    map.put("customerId", customerId);
                } else {
                    map.put("customerId", -1);
                }
            }
        }
        //获取当前登录用户
        User user = (User) session.getAttribute("currentUser");
        map.put("userId", user.getId());
        map.put("status", 1);
        map.put("start", pageBean.getStart());
        map.put("size", pageBean.getPageSize());
        resultMap.put("rows", inquiryService.list(map));
        resultMap.put("total", inquiryService.getCount(map));
        logService.add(new Log(Log.SEARCH_ACTION, "查看我答复的客户网上问诊"));
        return resultMap;
    }

    /**
     * 查看全部网上问诊
     *
     * @param inquiry
     * @param page
     * @param rows
     * @return
     */
    @RequestMapping("/listAllInquiry")
    @RequiresPermissions(value = "问诊记录管理")
    public Map<String, Object> listAllInquiry(Inquiry inquiry, @RequestParam(value = "page", required = false) Integer page, @RequestParam(value = "rows", required = false) Integer rows) {
        PageBean pageBean = new PageBean(page, rows);
        Map<String, Object> resultMap = new HashMap<>(16);
        Map<String, Object> map = new HashMap<>(16);
        if (inquiry.getCustomer() != null) {
            if (!StringUtil.isEmpty(inquiry.getCustomer().getContact())) {
                Customer customer = customerService.findByContact(inquiry.getCustomer().getContact());
                if (customer != null) {
                    int customerId = customer.getId();
                    map.put("customerId", customerId);
                } else {
                    map.put("customerId", -1);
                }
            }
        }
        map.put("start", pageBean.getStart());
        map.put("size", pageBean.getPageSize());
        resultMap.put("rows", inquiryService.list(map));
        resultMap.put("total", inquiryService.getCount(map));
        logService.add(new Log(Log.SEARCH_ACTION, "查看未答复的客户网上问诊"));
        return resultMap;
    }

    /**
     * 医生修改网上问诊信息
     *
     * @param inquiry
     * @return
     */
    @RequestMapping("/save")
    @RequiresPermissions(value = "网上问诊")
    public Map<String, Object> save(Inquiry inquiry, HttpSession session) {
        Map<String, Object> resultMap = new HashMap<>(16);
        User currentUser = (User) session.getAttribute("currentUser");
        inquiry.setUser(currentUser);
        inquiry.setStatus(1);
        int key;
        logService.add(new Log(Log.UPDATE_ACTION, "修改客户问诊" + inquiry));
        if (currentUser != null) {
            key = inquiryService.update(inquiry);
            if (key > 0) {
                resultMap.put("success", true);
            } else {
                resultMap.put("success", false);
            }
        } else {
            resultMap.put("success", false);
            resultMap.put("errorInfo", "登录状态过期,请重新登录!!");
        }
        return resultMap;
    }

    /**
     * 管理员修改网上问诊信息
     *
     * @param inquiry
     * @return
     */
    @RequestMapping("/managerSave")
    @RequiresPermissions(value = "问诊记录管理")
    public Map<String, Object> managerSave(Inquiry inquiry) {
        Map<String, Object> resultMap = new HashMap<>(16);
        Inquiry inquiry1 = inquiryService.findById(inquiry.getId());
        int key=0;
        if (inquiry1.getUser() != null) {
            logService.add(new Log(Log.UPDATE_ACTION, "修改客户问诊" + inquiry));
            key = inquiryService.update(inquiry);
        }
        if (key > 0) {
            resultMap.put("success", true);
        } else {
            resultMap.put("errorInfo", "该客户问诊未被医生回复,不能修改!!");
            resultMap.put("success", false);
        }
        return resultMap;
    }

    /**
     * 管理员删除网上问诊
     *
     * @param ids
     * @return
     */
    @RequestMapping("/delete")
    @RequiresPermissions(value = "问诊记录管理")
    public Map<String, Object> delete(String ids) {
        Map<String, Object> resultMap = new HashMap<>(16);
        String[] idsStr = ids.split(",");
        for (int i = 0; i < idsStr.length; i++) {
            int id = Integer.parseInt(idsStr[i]);
            logService.add(new Log(Log.DELETE_ACTION, "删除问诊" + inquiryService.findById(id)));
            Inquiry inquiry = inquiryService.findById(id);
            if (inquiry.getImageName() != null) {
                FileUtils.deleteQuietly(new File(inquiryImageFilePath + inquiryService.findById(inquiry.getId()).getImageName()));
            }
            inquiryService.delete(id);
        }
        resultMap.put("success", true);
        return resultMap;
    }
}
