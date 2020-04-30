package com.ledao.controller;

import com.ledao.entity.Customer;
import com.ledao.entity.Suggestion;
import com.ledao.service.SuggestionService;
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
 * 前台客户留言Controller层
 *
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
     * 查看我的留言
     *
     * @param page
     * @param session
     * @return
     */
    @RequestMapping("/mySuggestion/list/{id}")
    public ModelAndView myWord(@PathVariable(value = "id", required = false) Integer page, HttpSession session) {
        ModelAndView mav = new ModelAndView();
        Map<String, Object> map = new HashMap<>(16);
        int pageSize = 3;
        map.put("start", (page - 1) * pageSize);
        map.put("size", pageSize);
        Customer currentCustomer = (Customer) session.getAttribute("currentCustomer");
        map.put("customerId", currentCustomer.getId());
        List<Suggestion> mySuggestionList = suggestionService.list(map);
        Long total = suggestionService.getCount(map);
        mav.addObject("todaySubmitTimes", suggestionService.getCountTodaySuggestion(currentCustomer.getId()));
        mav.addObject("remainingSubmitTimes", 5 - suggestionService.getCountTodaySuggestion(currentCustomer.getId()));
        mav.addObject("mySuggestionList", mySuggestionList);
        mav.addObject("total", total);
        mav.addObject("pageCode", PageUtil.genPagination2("/suggestion/mySuggestion/list", total, page, pageSize));
        mav.addObject("title", "我的留言");
        mav.addObject("mainPage", "page/customer/mySuggestion");
        mav.addObject("mainPageKey", "#b");
        mav.setViewName("index");
        return mav;
    }

    /**
     * 客户添加建议或反馈
     *
     * @param suggestion
     * @param session
     * @return
     */
    @RequestMapping("/save")
    public ModelAndView save(Suggestion suggestion, HttpSession session) {
        ModelAndView mav = new ModelAndView("redirect:/suggestion/mySuggestion/list/1");
        Customer currentCustomer = (Customer) session.getAttribute("currentCustomer");
        if (suggestion.getId() == null) {
            //每日最大留言次数
            int maxSubmitTimes = 5;
            if (suggestionService.getCountTodaySuggestion(currentCustomer.getId()) >= maxSubmitTimes) {
                return mav;
            } else {
                suggestion.setCustomer(currentCustomer);
                suggestionService.add(suggestion);
            }
        }
        return mav;
    }
}
