package com.ledao.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

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
    public String root() {
        return "redirect:/login.html";
    }
}
