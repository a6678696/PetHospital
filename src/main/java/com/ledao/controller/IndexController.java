package com.ledao.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

/**
 * 首页Controller
 *
 * @author LeDao
 * @company
 * @create 2020-01-16 19:10
 */
@Controller
public class IndexController {

    /**
     * 首页地址
     *
     * @return
     */
    @RequestMapping("/")
    public ModelAndView root() {
        ModelAndView mav = new ModelAndView();
        mav.addObject("title", "首页");
        mav.addObject("mainPage", "page/indexFirst");
        mav.addObject("mainPageKey","#b");
        mav.setViewName("index");
        return mav;
    }
}
