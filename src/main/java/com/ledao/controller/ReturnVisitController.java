package com.ledao.controller;

import com.ledao.entity.ReturnVisit;
import com.ledao.entity.Customer;
import com.ledao.entity.Pet;
import com.ledao.service.ReturnVisitService;
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
 * 前台客户回访记录Controller层
 *
 * @author LeDao
 * @company
 * @create 2020-03-19 19:21
 */
@Controller
@RequestMapping("/returnVisit")
public class ReturnVisitController {

    @Resource
    private ReturnVisitService returnVisitService;

    @Resource
    private PetService petService;

    /**
     * 我的客户回访记录
     *
     * @param page
     * @param session
     * @return
     */
    @RequestMapping("/myReturnVisit/list/{id}")
    public ModelAndView myReturnVisit(@PathVariable(value = "id", required = false) Integer page, HttpSession session) {
        ModelAndView mav = new ModelAndView();
        Map<String, Object> map = new HashMap<>(16);
        int pageSize = 4;
        map.put("start", (page - 1) * pageSize);
        map.put("size", pageSize);
        Customer currentCustomer = (Customer) session.getAttribute("currentCustomer");
        map.put("customerName", StringUtil.formatLike(currentCustomer.getContact()));
        List<ReturnVisit> returnVisitList = returnVisitService.list(map);
        for (ReturnVisit returnVisit : returnVisitList) {
            Pet pet = petService.findByName(returnVisit.getPetName());
            returnVisit.setPet(pet);
        }
        Long total = returnVisitService.getCount(map);
        mav.addObject("returnVisitList", returnVisitList);
        mav.addObject("total", total);
        mav.addObject("pageCode", PageUtil.genPagination2("/returnVisit/myReturnVisit/list", total, page, pageSize));
        mav.addObject("title", "我的客户回访记录");
        mav.addObject("mainPage", "page/returnVisit/myReturnVisit");
        mav.addObject("mainPageKey", "#b");
        mav.setViewName("index");
        return mav;
    }

    /**
     * 查看客户回访记录详情
     *
     * @param returnVisitId
     * @return
     */
    @RequestMapping("/returnVisitDetails")
    public ModelAndView returnVisitDetails(Integer returnVisitId) {
        ReturnVisit returnVisit = returnVisitService.findById(returnVisitId);
        ModelAndView mav = new ModelAndView();
        mav.addObject("returnVisit", returnVisit);
        mav.addObject("title", "查看客户回访记录详情");
        mav.addObject("mainPage", "page/returnVisit/returnVisitDetails");
        mav.addObject("mainPageKey", "#b");
        mav.setViewName("index");
        return mav;
    }
}
