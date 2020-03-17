package com.ledao.controller.admin;

import com.ledao.entity.*;
import com.ledao.service.CustomerService;
import com.ledao.service.LogService;
import com.ledao.service.SuggestionService;
import com.ledao.util.StringUtil;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author LeDao
 * @company
 * @create 2020-03-09 23:40
 */
@RestController
@RequestMapping("/admin/suggestion")
public class SuggestionAdminController {

    @Resource
    private SuggestionService suggestionService;

    @Resource
    private CustomerService customerService;

    @Resource
    private LogService logService;

    /**
     * 分页分条件查询客户留言
     *
     * @param suggestion
     * @param page
     * @param rows
     * @return
     */
    @RequestMapping("/list")
    @RequiresPermissions(value = "客户留言管理")
    public Map<String, Object> list(Suggestion suggestion, @RequestParam(value = "page", required = false) Integer page, @RequestParam(value = "rows", required = false) Integer rows) {
        PageBean pageBean = new PageBean(page, rows);
        Map<String, Object> resultMap = new HashMap<>(16);
        Map<String, Object> map = new HashMap<>(16);
        if (suggestion.getCustomer() != null) {
            if (!StringUtil.isEmpty(suggestion.getCustomer().getContact())) {
                Customer customer = customerService.findByContact(suggestion.getCustomer().getContact());
                if (customer != null) {
                    int customerId = customer.getId();
                    map.put("customerId", customerId);
                } else {
                    map.put("customerId", -1);
                }
            }
        }
        map.put("start", pageBean.getStart());
        map.put("size", pageBean.getPageSize());
        List<Suggestion> suggestionList = suggestionService.list(map);
        Long total = suggestionService.getCount(map);
        resultMap.put("rows", suggestionList);
        resultMap.put("total", total);
        logService.add(new Log(Log.SEARCH_ACTION, "查询客户留言"));
        return resultMap;
    }

    /**
     * 修改客户留言
     *
     * @param suggestion
     * @return
     */
    @RequestMapping("/save")
    @RequiresPermissions(value = "客户留言管理")
    public Map<String, Object> save(Suggestion suggestion, HttpSession session) {
        Map<String, Object> resultMap = new HashMap<>(16);
        User currentUser = (User) session.getAttribute("currentUser");
        suggestion.setUser(currentUser);
        int key;
        logService.add(new Log(Log.UPDATE_ACTION, "修改客户留言" + suggestion));
        if (currentUser != null) {
            key = suggestionService.update(suggestion);
            if (key > 0) {
                resultMap.put("success", true);
            } else {
                resultMap.put("success", false);
            }
        } else {
            resultMap.put("success", false);
            resultMap.put("errorInfo", "登录状态过期,请重新登录!!");
        }
        return resultMap;
    }

    /**
     * 删除文章类型,可批量删除
     *
     * @param ids
     * @return
     */
    @RequestMapping("/delete")
    @RequiresPermissions(value = "客户留言管理")
    public Map<String, Object> delete(String ids) {
        Map<String, Object> resultMap = new HashMap<>(16);
        String[] idsStr = ids.split(",");
        for (int i = 0; i < idsStr.length; i++) {
            int id = Integer.parseInt(idsStr[i]);
            logService.add(new Log(Log.DELETE_ACTION, "删除文章类型" + suggestionService.findById(id)));
            suggestionService.delete(id);
        }
        resultMap.put("success", true);
        return resultMap;
    }
}
