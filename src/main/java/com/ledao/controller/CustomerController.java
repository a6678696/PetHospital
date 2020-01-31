package com.ledao.controller;

import com.ledao.entity.Customer;
import com.ledao.entity.Log;
import com.ledao.service.CustomerService;
import com.ledao.service.LogService;
import com.ledao.util.DateUtil;
import org.apache.commons.io.FileUtils;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;
import javax.validation.Valid;
import java.io.File;
import java.util.HashMap;
import java.util.Map;

/**
 * 前台客户Controller层
 *
 * @author LeDao
 * @company
 * @create 2020-01-30 14:57
 */
@Controller
@RequestMapping("/customer")
public class CustomerController {

    @Value("${customerImageFilePath}")
    private String customerImageFilePath;

    @Resource
    private CustomerService customerService;

    /**
     * 添加或者修改客户信息
     *
     * @param customer
     * @return
     */
    @RequestMapping("/save")
    public ModelAndView save(@Valid Customer customer, BindingResult bindingResult, @RequestParam("customerImage") MultipartFile file) throws Exception {
        ModelAndView mav = new ModelAndView();
        if (bindingResult.hasErrors()) {
            mav.addObject("customer", customer);
            mav.addObject("error", bindingResult.getFieldError().getDefaultMessage());
            mav.addObject("title", "用户注册");
            mav.addObject("mainPage", "page/register");
        } else if (!customer.getPassword2().equals(customer.getPassword())) {
            mav.addObject("customer", customer);
            mav.addObject("error", "密码和确认密码不相同,请重新输入!");
            mav.addObject("title", "用户注册");
            mav.addObject("mainPage", "page/register");
        } else if (customerService.getCountByUserName(customer.getUserName()) != 0) {
            mav.addObject("customer", customer);
            mav.addObject("error", "您要注册的用户名已经存在,请重新输入!");
            mav.addObject("title", "用户注册");
            mav.addObject("mainPage", "page/register");
        } else {
            if (!file.isEmpty()) {
                // 获取上传的文件名
                String fileName = file.getOriginalFilename();
                // 获取文件的后缀
                String suffixName = fileName.substring(fileName.lastIndexOf("."));
                String newFileName = DateUtil.getCurrentDateStr2() + suffixName;
                FileUtils.copyInputStreamToFile(file.getInputStream(), new File(customerImageFilePath + newFileName));
                if (customer.getId() != null) {
                    FileUtils.deleteQuietly(new File(customerImageFilePath + customerService.findById(customer.getId()).getImageName()));
                }
                customer.setImageName(newFileName);
            }
            if (customer.getId() == null) {
                customerService.add(customer);
            } else {
                customerService.update(customer);
            }
            mav.addObject("successRegister", true);
            mav.addObject("title", "用户登录");
            mav.addObject("mainPage", "page/login");
        }
        mav.addObject("mainPageKey", "#b");
        mav.setViewName("index");
        return mav;
    }

    /**
     * 客户登录
     *
     * @param customer
     * @param bindingResult
     * @param session
     * @return
     */
    @RequestMapping("/login")
    public ModelAndView login(@Valid Customer customer, BindingResult bindingResult, HttpSession session) {
        ModelAndView mav = new ModelAndView();
        if (bindingResult.hasErrors()) {
            mav.addObject("customer", customer);
            mav.addObject("error", bindingResult.getFieldError().getDefaultMessage());
            mav.addObject("title", "用户登录");
            mav.addObject("mainPage", "page/login");
        } else {
            Customer currentCustomer = customerService.findByUserName(customer.getUserName()).get(0);
            if (currentCustomer.getPassword().equals(customer.getPassword())) {
                session.setAttribute("currentCustomer", currentCustomer);
                mav.addObject("successLogin", true);
                mav.addObject("title", "首页");
                mav.addObject("mainPage", "page/indexFirst");
            } else {
                mav.addObject("successLogin", false);
                mav.addObject("title", "用户登录");
                mav.addObject("mainPage", "page/login");
            }
        }
        mav.addObject("mainPageKey", "#b");
        mav.setViewName("index");
        return mav;
    }

    @RequestMapping("/logout")
    public ModelAndView logout(HttpSession session) {
        ModelAndView mav = new ModelAndView();
        session.invalidate();
        mav.addObject("title", "用户登录");
        mav.addObject("mainPage", "page/indexFirst");
        mav.addObject("mainPageKey", "#b");
        mav.setViewName("index");
        return mav;
    }

    @ResponseBody
    @RequestMapping("/existUserWithUserName")
    public Map<String, Object> existUserWithUserName(String userName) {
        Map<String, Object> resultMap = new HashMap<>(16);
        Long count = customerService.getCountByUserName(userName);
        if (count != 0) {
            resultMap.put("success", true);
        } else {
            resultMap.put("success", false);
        }
        return resultMap;
    }
}
