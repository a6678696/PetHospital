package com.ledao.controller.admin;

import com.ledao.entity.Log;
import com.ledao.entity.PageBean;
import com.ledao.entity.User;
import com.ledao.service.LogService;
import com.ledao.service.UserService;
import com.ledao.util.StringUtil;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 后台管理系统日志Controller
 *
 * @author LeDao
 * @company
 * @create 2020-01-18 21:30
 */
@RestController
@RequestMapping("/admin/log")
public class LogAdminController {

    @Resource
    private LogService logService;

    @Resource
    private UserService userService;

    @InitBinder
    public void initBinder(WebDataBinder binder) {
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        dateFormat.setLenient(true);
        //true:允许输入空值，false:不能为空值
        binder.registerCustomEditor(Date.class, new CustomDateEditor(dateFormat, true));
    }

    /**
     * 根据条件分页查询日志信息
     *
     * @param searchLog
     * @param page
     * @param rows
     * @return
     */
    @RequestMapping("/list")
    @RequiresPermissions(value = "系统日志")
    public Map<String, Object> list(Log searchLog, @RequestParam(value = "page", required = false) Integer page, @RequestParam(value = "rows", required = false) Integer rows) {
        PageBean pageBean = new PageBean(page, rows);
        Map<String, Object> resultMap = new HashMap<>(16);
        Map<String, Object> map = new HashMap<>(16);
        map.put("type", searchLog.getType());
        if (searchLog.getUser() != null) {
            if (!StringUtil.isEmpty(searchLog.getUser().getTrueName())) {
                User user = userService.findByTrueName(searchLog.getUser().getTrueName());
                if (user != null) {
                    int userId = user.getId();
                    map.put("userId", userId);
                } else {
                    map.put("userId", -1);
                }
            }
        }
        map.put("bTime", searchLog.getbTime());
        map.put("eTime", searchLog.geteTime());
        map.put("start", pageBean.getStart());
        map.put("size", pageBean.getPageSize());
        List<Log> logList = logService.list(map);
        Long total = logService.getCount(map);
        resultMap.put("rows", logList);
        resultMap.put("total", total);
        return resultMap;
    }
}
