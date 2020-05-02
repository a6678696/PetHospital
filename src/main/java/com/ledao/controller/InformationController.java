package com.ledao.controller;

import com.ledao.entity.Information;
import com.ledao.service.InformationService;
import com.ledao.util.PageUtil;
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
 * 客户消息Controller层
 *
 * @author LeDao
 * @company
 * @create 2020-05-02 17:42
 */
@Controller
@RequestMapping("/information")
public class InformationController {

    @Resource
    private InformationService informationService;

    /**
     * 顾客查看系统发送给自己的消息
     *
     * @param page
     * @param session
     * @return
     */
    @RequestMapping("/myInformation/list/{id}")
    public ModelAndView myInformation(@PathVariable(value = "id", required = false) Integer page, HttpSession session) {
        ModelAndView mav = new ModelAndView();
        Map<String, Object> map = new HashMap<>(16);
        int pageSize = 6;
        map.put("start", (page - 1) * pageSize);
        map.put("size", pageSize);
        map.put("customer", session.getAttribute("currentCustomer"));
        List<Information> informationList = informationService.list(map);
        Long total = informationService.getCount(map);
        mav.addObject("informationList", informationList);
        mav.addObject("total", total);
        mav.addObject("pageCode", PageUtil.genPagination2("/information/myInformation/list", total, page, pageSize));
        mav.addObject("title", "我的消息");
        mav.addObject("mainPage", "page/information/myInformation");
        mav.addObject("mainPageKey", "#b");
        mav.setViewName("index");
        return mav;
    }

    /**
     * 客户查看消息详情
     *
     * @param id
     * @return
     */
    @RequestMapping("/informationDetails")
    public ModelAndView informationDetails(Integer id) {
        Information information = informationService.findById(id);
        information.setIsRead(1);
        informationService.update(information);
        ModelAndView mav = new ModelAndView();
        mav.addObject("information", information);
        mav.addObject("title", "查看消息详情");
        mav.addObject("mainPage", "page/information/informationDetails");
        mav.addObject("mainPageKey", "#b");
        mav.setViewName("index");
        return mav;
    }
}
