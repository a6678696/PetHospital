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
        mav.addObject("mainPageKey", "#b");
        mav.setViewName("index");
        return mav;
    }

    /**
     * 用户注册地址
     *
     * @return
     */
    @RequestMapping("/register")
    public ModelAndView register() {
        ModelAndView mav = new ModelAndView();
        mav.addObject("title", "用户注册");
        mav.addObject("mainPage", "page/register");
        mav.addObject("mainPageKey", "#b");
        mav.setViewName("index");
        return mav;
    }

    /**
     * 用户注册
     *
     * @return
     */
    @RequestMapping("/login")
    public ModelAndView login() {
        ModelAndView mav = new ModelAndView();
        mav.addObject("title", "用户登录");
        mav.addObject("mainPage", "page/login");
        mav.addObject("mainPageKey", "#b");
        mav.setViewName("index");
        return mav;
    }

    /**
     * 用户注册
     *
     * @return
     */
    @RequestMapping("/shoppingCart")
    public ModelAndView shoppingCart() {
        ModelAndView mav = new ModelAndView();
        mav.addObject("title", "我的购物车");
        mav.addObject("mainPage", "page/goods/shoppingCart");
        mav.addObject("mainPageKey", "#b");
        mav.setViewName("index");
        return mav;
    }
}
