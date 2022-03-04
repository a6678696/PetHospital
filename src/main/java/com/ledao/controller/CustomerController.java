package com.ledao.controller;

import com.ledao.entity.Customer;
import com.ledao.entity.Log;
import com.ledao.entity.Pet;
import com.ledao.service.CustomerService;
import com.ledao.service.LogService;
import com.ledao.service.PetService;
import com.ledao.util.DateUtil;
import com.ledao.util.PageUtil;
import org.apache.commons.io.FileUtils;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PathVariable;
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
import java.util.List;
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

    @Resource
    private PetService petService;

    /**
     * 添加或者修改客户信息
     *
     * @param customer
     * @return
     */
    @RequestMapping("/save")
    public ModelAndView save(Customer customer, @RequestParam("customerImage") MultipartFile file, HttpSession session) throws Exception {
        if (!file.isEmpty()) {
            if (customer.getId() != null) {
                File file1 = new File(String.valueOf(new File(customerImageFilePath + customerService.findById(customer.getId()).getImageName())));
                if (file1.exists()) {
                    FileUtils.deleteQuietly(file1);
                }
            }
            // 获取上传的文件名
            String fileName = file.getOriginalFilename();
            // 获取文件的后缀
            String suffixName = fileName.substring(fileName.lastIndexOf("."));
            String newFileName = DateUtil.getCurrentDateStr2() + suffixName;
            FileUtils.copyInputStreamToFile(file.getInputStream(), new File(customerImageFilePath + newFileName));
            customer.setImageName(newFileName);
        }
        if (customer.getId() == null) {
            customerService.add(customer);
            ModelAndView mav = new ModelAndView("redirect:/login");
            mav.addObject("successRegister", true);
            mav.addObject("title", "用户登录");
            mav.addObject("mainPage", "page/login");
            mav.addObject("mainPageKey", "#b");
            return mav;
        } else {
            customerService.update(customer);
            ModelAndView mav = new ModelAndView("redirect:/customer/personalCenter");
            mav.addObject("successModify", true);
            mav.addObject("title", "个人中心");
            mav.addObject("mainPage", "page/customer/personalCenterFirst");
            customer.setImageName(customerService.findById(customer.getId()).getImageName());
            session.setAttribute("currentCustomer", customer);
            mav.addObject("mainPageKey", "#b");
            return mav;
        }
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
            List<Customer> customerList = customerService.findByUserName(customer.getUserName());
            if (customerList.size() != 0) {
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

    /**
     * 退出登录返回的页面
     *
     * @param session
     * @return
     */
    @RequestMapping("/logout")
    public ModelAndView logout(HttpSession session) {
        session.invalidate();
        ModelAndView mav = new ModelAndView("");
        mav.addObject("title", "用户登录");
        mav.addObject("mainPage", "page/indexFirst");
        mav.addObject("mainPageKey", "#b");
        mav.setViewName("index");
        return mav;
    }

    /**
     * 跳转到修改个人中心页面
     *
     * @return
     */
    @RequestMapping("/personalCenter")
    public ModelAndView personalCenter() {
        ModelAndView mav = new ModelAndView();
        mav.addObject("title", "个人中心");
        mav.addObject("mainPage", "page/customer/personalCenterFirst");
        mav.addObject("mainPageKey", "#b");
        mav.setViewName("index");
        return mav;
    }

    /**
     * 跳转到修改个人信息页面
     *
     * @return
     */
    @RequestMapping("/personalCenter/ModifyMessage")
    public ModelAndView personalCenterModifyMessage() {
        ModelAndView mav = new ModelAndView();
        mav.addObject("title", "修改个人信息");
        mav.addObject("mainPage", "page/customer/personalCenterModifyMessage");
        mav.addObject("mainPageKey", "#b");
        mav.setViewName("index");
        return mav;
    }

    /**
     * 客户注册时判断用户名是否已经存在
     *
     * @param userName
     * @return
     */
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

    /**
     * 查看我的宠物
     *
     * @return
     */
    @RequestMapping("/myPet/list/{id}")
    public ModelAndView myPet(@PathVariable(value = "id", required = false) Integer page, HttpSession session) {
        ModelAndView mav = new ModelAndView();
        Map<String, Object> map = new HashMap<>(16);
        int pageSize = 3;
        map.put("start", (page - 1) * pageSize);
        map.put("size", pageSize);
        map.put("customer", session.getAttribute("currentCustomer"));
        List<Pet> petList = petService.list(map);
        Long total = petService.getCount(map);
        mav.addObject("petList", petList);
        mav.addObject("total", total);
        mav.addObject("pageCode", PageUtil.genPagination2("/customer/myPet/list", total, page, pageSize));
        mav.addObject("title", "我的宠物");
        mav.addObject("mainPage", "page/customer/myPet");
        mav.addObject("mainPageKey", "#b");
        mav.setViewName("index");
        return mav;
    }

    /**
     * 添加宠物信息页面
     *
     * @return
     */
    @RequestMapping("/petAdd")
    public ModelAndView petAdd() {
        ModelAndView mav = new ModelAndView();
        mav.addObject("title", "添加宠物信息");
        mav.addObject("mainPage", "page/customer/petAdd");
        mav.addObject("mainPageKey", "#b");
        mav.setViewName("index");
        return mav;
    }

    /**
     * 修改宠物信息页面
     *
     * @param petId
     * @return
     */
    @RequestMapping("/petModify")
    public ModelAndView petModify(Integer petId) {
        Pet pet = petService.findById(petId);
        ModelAndView mav = new ModelAndView();
        mav.addObject("pet", pet);
        mav.addObject("title", "修改宠物信息");
        mav.addObject("mainPage", "page/customer/petModify");
        mav.addObject("mainPageKey", "#b");
        mav.setViewName("index");
        return mav;
    }

    /**
     * 查看宠物信息页面
     *
     * @param petId
     * @return
     */
    @RequestMapping("/petDetails")
    public ModelAndView petDetails(Integer petId) {
        Pet pet = petService.findById(petId);
        ModelAndView mav = new ModelAndView();
        mav.addObject("pet", pet);
        mav.addObject("title", "查看宠物信息");
        mav.addObject("mainPage", "page/customer/petDetails");
        mav.addObject("mainPageKey", "#b");
        mav.setViewName("index");
        return mav;
    }
}
