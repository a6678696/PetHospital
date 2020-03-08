package com.ledao.controller;

import com.alibaba.druid.sql.dialect.h2.visitor.H2ASTVisitor;
import com.ledao.entity.Customer;
import com.ledao.entity.Suggestion;
import com.ledao.service.SuggestionService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;

/**
 * @author LeDao
 * @company
 * @create 2020-03-08 11:29
 */
@Controller
@RequestMapping("/suggestion")
public class SuggestionController {

    @Resource
    private SuggestionService suggestionService;

    /**
     * 客户添加建议或反馈
     *
     * @param suggestion
     * @param session
     * @return
     */
    @RequestMapping("/save")
    public ModelAndView save(Suggestion suggestion, HttpSession session) {
        ModelAndView mav = new ModelAndView();
        Customer currentCustomer = (Customer) session.getAttribute("currentCustomer");
        if (suggestion.getId() == null) {
            if (suggestionService.getCountTodaySuggestion(currentCustomer.getId()) == 1) {
                mav.addObject("error", "您今天已经发过言,请明天再来吧Σ( ° △ °|||)︴");
            } else {
                mav.addObject("systemMessage", "发言成功!!");
                suggestion.setCustomer(currentCustomer);
                suggestionService.add(suggestion);
            }
        }
        mav.addObject("title", "联系我们");
        mav.addObject("mainPage", "page/contact");
        mav.addObject("mainPageKey", "#b");
        mav.setViewName("index");
        return mav;
    }
}
