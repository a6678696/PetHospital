package com.ledao.controller.admin;

import com.ledao.entity.*;
import com.ledao.service.InformationService;
import com.ledao.service.LogService;
import com.ledao.util.StringUtil;
import org.apache.shiro.authz.annotation.Logical;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 后台管理客户消息Controller层
 *
 * @author LeDao
 * @company
 * @create 2020-05-03 15:25
 */
@RestController
@RequestMapping("/admin/information")
public class InformationAdminController {

    @Resource
    private InformationService informationService;

    @Resource
    private LogService logService;

    /**
     * 分页分条件查询客户消息
     *
     * @param information
     * @param page
     * @param rows
     * @return
     */
    @RequestMapping("/list")
    @RequiresPermissions(value = "客户消息管理")
    public Map<String, Object> list(Information information, @RequestParam(value = "page", required = false) Integer page, @RequestParam(value = "rows", required = false) Integer rows) {
        PageBean pageBean = new PageBean(page, rows);
        Map<String, Object> resultMap = new HashMap<>(16);
        Map<String, Object> map = new HashMap<>(16);
        if (information.getCustomer() != null) {
            map.put("customerId", information.getCustomer().getId());
        }
        map.put("isRead", information.getIsRead());
        map.put("start", pageBean.getStart());
        map.put("size", pageBean.getPageSize());
        List<Information> informationList = informationService.list(map);
        Long total = informationService.getCount(map);
        resultMap.put("rows", informationList);
        resultMap.put("total", total);
        logService.add(new Log(Log.SEARCH_ACTION, "查询客户消息"));
        return resultMap;
    }

    /**
     * 添加或修改客户消息
     *
     * @param information
     * @return
     */
    @RequestMapping("/save")
    @RequiresPermissions(value = "客户消息管理")
    public Map<String, Object> save(Information information, HttpSession session) {
        Map<String, Object> resultMap = new HashMap<>(16);
        int key=0;
        if (information.getId() == null) {
            information.setIsRead(0);
            User currentUser = (User) session.getAttribute("currentUser");
            information.setUser(currentUser);
            if (information.getUser() == null) {
                resultMap.put("errorInfo", "长时间无操作,登录状态已到期,请重新登录!!");
            } else {
                logService.add(new Log(Log.ADD_ACTION, "添加客户消息" + information));
                key = informationService.add(information);
            }
        } else {
            logService.add(new Log(Log.UPDATE_ACTION, "修改客户消息" + information));
            key = informationService.update(information);
        }
        if (key > 0) {
            resultMap.put("success", true);
        } else {
            resultMap.put("success", false);
        }
        return resultMap;
    }

    /**
     * 删除客户消息,可批量删除
     *
     * @param ids
     * @return
     */
    @RequestMapping("/delete")
    @RequiresPermissions(value = "客户消息管理")
    public Map<String, Object> delete(String ids) {
        Map<String, Object> resultMap = new HashMap<>(16);
        String[] idsStr = ids.split(",");
        for (int i = 0; i < idsStr.length; i++) {
            int id = Integer.parseInt(idsStr[i]);
            logService.add(new Log(Log.DELETE_ACTION, "删除客户消息" + informationService.findById(id)));
            informationService.delete(id);
        }
        resultMap.put("success", true);
        return resultMap;
    }
}
