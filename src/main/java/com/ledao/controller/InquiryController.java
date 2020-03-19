package com.ledao.controller;

import com.ledao.entity.Customer;
import com.ledao.entity.Inquiry;
import com.ledao.entity.Pet;
import com.ledao.service.InquiryService;
import com.ledao.service.PetService;
import com.ledao.util.DateUtil;
import com.ledao.util.PageUtil;
import org.apache.commons.io.FileUtils;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;
import java.io.File;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 前台客户问诊Controller层
 *
 * @author LeDao
 * @company
 * @create 2020-03-10 22:43
 */
@Controller
@RequestMapping("/inquiry")
public class InquiryController {

    @Value("${inquiryImageFilePath}")
    private String inquiryImageFilePath;

    @Resource
    private InquiryService inquiryService;

    @Resource
    private PetService petService;

    /**
     * 客户创建问诊单
     *
     * @return
     */
    @RequestMapping("/createInquiry")
    public ModelAndView createInquiry(HttpSession session) {
        ModelAndView mav = new ModelAndView();
        Customer currentCustomer = (Customer) session.getAttribute("currentCustomer");
        Map<String, Object> map = new HashMap<>(16);
        map.put("customer", currentCustomer);
        mav.addObject("petList", petService.list(map));
        mav.addObject("title", "客户问诊");
        mav.addObject("mainPage", "page/inquiry/createInquiry");
        mav.addObject("mainPageKey", "#b");
        mav.setViewName("index");
        return mav;
    }

    /**
     * 添加或者修改客户信息
     *
     * @param inquiry
     * @return
     */
    @RequestMapping("/save")
    public ModelAndView save(Inquiry inquiry, @RequestParam("inquiryImage") MultipartFile file, HttpSession session) throws Exception {
        if (!file.isEmpty()) {
            if (inquiry.getId() != null) {
                FileUtils.deleteQuietly(new File(inquiryImageFilePath + inquiryService.findById(inquiry.getId()).getImageName()));
            }
            // 获取上传的文件名
            String fileName = file.getOriginalFilename();
            // 获取文件的后缀
            String suffixName = fileName.substring(fileName.lastIndexOf("."));
            String newFileName = DateUtil.getCurrentDateStr2() + suffixName;
            FileUtils.copyInputStreamToFile(file.getInputStream(), new File(inquiryImageFilePath + newFileName));
            inquiry.setImageName(newFileName);
        }
        if (inquiry.getId() == null) {
            Customer currentCustomer = (Customer) session.getAttribute("currentCustomer");
            inquiry.setCustomer(currentCustomer);
            Pet pet = petService.findById(inquiry.getPetId());
            inquiry.setPet(pet);
            inquiryService.add(inquiry);
            ModelAndView mav = new ModelAndView("redirect:/inquiry/myInquiry/list/1");
            return mav;
        } else {
            Pet pet = petService.findById(inquiry.getPetId());
            inquiry.setPet(pet);
            inquiryService.update(inquiry);
            ModelAndView mav = new ModelAndView("redirect:/inquiry/myInquiry/list/1");
            return mav;
        }
    }

    /**
     * 客户查看自己的问诊记录
     *
     * @param session
     * @return
     */
    @RequestMapping("/myInquiry/list/{id}")
    public ModelAndView myInquiry(@PathVariable(value = "id",required = false)Integer page, HttpSession session) {
        ModelAndView mav = new ModelAndView();
        Map<String, Object> map = new HashMap<>(16);
        int pageSize = 3;
        map.put("start", (page - 1) * pageSize);
        map.put("size", pageSize);
        map.put("customer", session.getAttribute("currentCustomer"));
        List<Inquiry> inquiryList = inquiryService.list(map);
        Long total = inquiryService.getCount(map);
        mav.addObject("inquiryList", inquiryList);
        mav.addObject("total", total);
        mav.addObject("pageCode", PageUtil.genPagination2("/inquiry/myInquiry/list", total, page, pageSize));
        mav.addObject("title", "问诊记录");
        mav.addObject("mainPage", "page/inquiry/myInquiry");
        mav.addObject("mainPageKey", "#b");
        mav.setViewName("index");
        return mav;
    }

    /**
     * 查看问诊信息页面
     *
     * @param inquiryId
     * @return
     */
    @RequestMapping("/inquiryDetails")
    public ModelAndView inquiryDetails(Integer inquiryId) {
        Inquiry inquiry = inquiryService.findById(inquiryId);
        ModelAndView mav = new ModelAndView();
        mav.addObject("inquiry", inquiry);
        mav.addObject("title", "查看问诊信息");
        mav.addObject("mainPage", "page/inquiry/inquiryDetails");
        mav.addObject("mainPageKey", "#b");
        mav.setViewName("index");
        return mav;
    }

    /**
     * 修改问诊信息页面
     *
     * @param inquiryId
     * @return
     */
    @RequestMapping("/inquiryModify")
    public ModelAndView inquiryModify(Integer inquiryId, HttpSession session) {
        Inquiry inquiry = inquiryService.findById(inquiryId);
        Map<String, Object> map = new HashMap<>(16);
        map.put("customer", session.getAttribute("currentCustomer"));
        List<Pet> petList = petService.list(map);
        ModelAndView mav = new ModelAndView();
        mav.addObject("inquiry", inquiry);
        mav.addObject("petList", petList);
        mav.addObject("title", "修改预约单信息");
        mav.addObject("mainPage", "page/inquiry/inquiryModify");
        mav.addObject("mainPageKey", "#b");
        mav.setViewName("index");
        return mav;
    }

    @RequestMapping("/deleteInquiry")
    public String deleteInquiry(Integer inquiryId) {
        Inquiry inquiry = inquiryService.findById(inquiryId);
        if (inquiry.getImageName() != null) {
            FileUtils.deleteQuietly(new File(inquiryImageFilePath + inquiryService.findById(inquiry.getId()).getImageName()));
        }
        inquiryService.delete(inquiryId);
        return "redirect:/inquiry/myInquiry/list/1";
    }
}
