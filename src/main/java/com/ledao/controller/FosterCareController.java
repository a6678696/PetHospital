package com.ledao.controller;

import com.ledao.entity.FosterCare;
import com.ledao.entity.Customer;
import com.ledao.entity.Pet;
import com.ledao.service.FosterCareService;
import com.ledao.service.PetService;
import com.ledao.util.PageUtil;
import com.ledao.util.StringUtil;
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
 * 前台宠物寄养Controller层
 *
 * @author LeDao
 * @company
 * @create 2020-03-21 15:09
 */
@Controller
@RequestMapping("/fosterCare")
public class FosterCareController {

    @Resource
    private FosterCareService fosterCareService;

    @Resource
    private PetService petService;

    /**
     * 我的宠物寄养记录
     *
     * @param page
     * @param session
     * @return
     */
    @RequestMapping("/myFosterCare/list/{id}")
    public ModelAndView myFosterCare(@PathVariable(value = "id", required = false) Integer page, HttpSession session) {
        ModelAndView mav = new ModelAndView();
        Map<String, Object> map = new HashMap<>(16);
        int pageSize = 4;
        map.put("start", (page - 1) * pageSize);
        map.put("size", pageSize);
        Customer currentCustomer = (Customer) session.getAttribute("currentCustomer");
        map.put("customerName", StringUtil.formatLike(currentCustomer.getContact()));
        map.put("customerId", currentCustomer.getId());
        List<FosterCare> fosterCareList = fosterCareService.list(map);
        Long total = fosterCareService.getCount(map);
        mav.addObject("fosterCareList", fosterCareList);
        mav.addObject("total", total);
        mav.addObject("pageCode", PageUtil.genPagination2("/fosterCare/myFosterCare/list", total, page, pageSize));
        mav.addObject("title", "我的宠物寄养记录");
        mav.addObject("mainPage", "page/fosterCare/myFosterCare");
        mav.addObject("mainPageKey", "#b");
        mav.setViewName("index");
        return mav;
    }

    /**
     * 查看宠物寄养记录详情
     *
     * @param fosterCareId
     * @return
     */
    @RequestMapping("/fosterCareDetails")
    public ModelAndView fosterCareDetails(Integer fosterCareId) {
        FosterCare fosterCare = fosterCareService.findById(fosterCareId);
        ModelAndView mav = new ModelAndView();
        mav.addObject("fosterCare", fosterCare);
        mav.addObject("title", "查看宠物寄养记录详情");
        mav.addObject("mainPage", "page/fosterCare/fosterCareDetails");
        mav.addObject("mainPageKey", "#b");
        mav.setViewName("index");
        return mav;
    }
}
