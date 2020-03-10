package com.ledao.controller;

import com.ledao.entity.Customer;
import com.ledao.entity.Inquiry;
import com.ledao.entity.Pet;
import com.ledao.service.InquiryService;
import com.ledao.service.PetService;
import com.ledao.util.DateUtil;
import org.apache.commons.io.FileUtils;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;
import java.io.File;
import java.util.HashMap;
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
        Map<String,Object> map=new HashMap<>(16);
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
            ModelAndView mav = new ModelAndView("redirect:/inquiry/createInquiry");
            return mav;
        } else {
            Pet pet = petService.findById(inquiry.getPetId());
            inquiry.setPet(pet);
            inquiryService.update(inquiry);
            ModelAndView mav = new ModelAndView("redirect:/customer/personalCenter");
            return mav;
        }
    }
}
