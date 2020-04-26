package com.ledao.controller.admin;

import com.ledao.entity.*;
import com.ledao.service.TackleService;
import com.ledao.service.LogService;
import com.ledao.service.TackleOutLogService;
import com.ledao.service.UserService;
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
 * 后台管理医院用品出库记录Controller层
 *
 * @author LeDao
 * @company
 * @create 2020-04-04 15:36
 */
@RestController
@RequestMapping("/admin/tackleOutLog")
public class TackleOutLogAdminController {

    @Resource
    private TackleOutLogService tackleOutLogService;

    @Resource
    private TackleService tackleService;

    @Resource
    private UserService userService;

    @Resource
    private LogService logService;

    @InitBinder
    public void initBinder(WebDataBinder binder) {
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        dateFormat.setLenient(true);
        //true:允许输入空值，false:不能为空值
        binder.registerCustomEditor(Date.class, new CustomDateEditor(dateFormat, true));
    }

    /**
     * 分页查询医院用品出库记录
     *
     * @param tackleOutLog
     * @param page
     * @param rows
     * @return
     */
    @RequestMapping("/list")
    @RequiresPermissions(value = "医院用品出入库记录管理")
    public Map<String, Object> list(TackleOutLog tackleOutLog, @RequestParam(value = "page", required = false) Integer page, @RequestParam(value = "rows", required = false) Integer rows) {
        PageBean pageBean = new PageBean(page, rows);
        Map<String, Object> resultMap = new HashMap<>(16);
        Map<String, Object> map = new HashMap<>(16);
        map.put("user", userService.findById(tackleOutLog.getUserId()));
        map.put("tackle", tackleService.findById(tackleOutLog.getTackleId()));
        map.put("start", pageBean.getStart());
        map.put("size", pageBean.getPageSize());
        resultMap.put("rows", tackleOutLogService.list(map));
        resultMap.put("total", tackleOutLogService.getCount(map));
        logService.add(new Log(Log.SEARCH_ACTION, "查询医院用品出库记录信息"));
        return resultMap;
    }

    /**
     * 添加或修改医院用品出库记录
     *
     * @param tackleOutLog
     * @return
     */
    @RequestMapping("/save")
    @RequiresPermissions(value = "医院用品出入库记录管理")
    public Map<String, Object> save(TackleOutLog tackleOutLog) {
        Map<String, Object> resultMap = new HashMap<>(16);
        if (tackleOutLog.getId() == null) {
            tackleOutLogService.add(tackleOutLog);
            logService.add(new Log(Log.ADD_ACTION, "添加医院用品出库记录" + tackleOutLog));
        } else {
            tackleOutLog.setUser(userService.findById(tackleOutLog.getUserId()));
            tackleOutLog.setTackle(tackleService.findById(tackleOutLog.getTackleId()));
            tackleOutLogService.update(tackleOutLog);
            logService.add(new Log(Log.UPDATE_ACTION, "修改医院用品出库记录" + tackleOutLog));
        }
        resultMap.put("success", true);
        return resultMap;
    }

    /**
     * 删除医院用品出库记录
     *
     * @param ids
     * @return
     */
    @RequestMapping("/delete")
    @RequiresPermissions(value = "医院用品出入库记录管理")
    public Map<String, Object> delete(String ids) {
        Map<String, Object> resultMap = new HashMap<>(16);
        String[] idsStr = ids.split(",");
        for (int i = 0; i < idsStr.length; i++) {
            int id = Integer.parseInt(idsStr[i]);
            logService.add(new Log(Log.DELETE_ACTION, "删除医院用品出库记录" + tackleOutLogService.findById(id)));
            tackleOutLogService.delete(id);
        }
        resultMap.put("success", true);
        return resultMap;
    }

    /**
     * 开始一个医院用品出库记录
     *
     * @param id
     * @param tackle
     * @return
     */
    @RequestMapping("/beginTackleOutLog")
    @RequiresPermissions(value = "医院用品出入库管理")
    public Map<String, Object> beginTackleOutLog(Integer id, Tackle tackle) {
        Map<String, Object> resultMap = new HashMap<>(16);
        User user = userService.findByTrueName(tackle.getUserName());
        if (user == null) {
            resultMap.put("success", false);
            resultMap.put("errorInfo", "您输入的用户的真实姓名不存在,请核实!!");
            return resultMap;
        }
        Tackle tackleSave = tackleService.findById(id);
        tackleSave.setStatus(1);
        tackleService.update(tackleSave);
        TackleOutLog tackleOutLog = new TackleOutLog();
        tackleOutLog.setTackle(tackleSave);
        tackleOutLog.setUser(user);
        tackleOutLogService.add(tackleOutLog);
        logService.add(new Log(Log.ADD_ACTION, "添加医院用品出库记录" + tackleOutLog));
        resultMap.put("success", true);
        return resultMap;
    }

    /**
     * 结束一个医院用品出库记录
     *
     * @param tackleId
     * @return
     */
    @RequestMapping("/endTackleOutLog")
    @RequiresPermissions(value = "医院用品出入库管理")
    public Map<String, Object> endTackleOutLog(Integer tackleId) {
        Map<String, Object> resultMap = new HashMap<>(16);
        Map<String, Object> map = new HashMap<>(16);
        Tackle tackle = tackleService.findById(tackleId);
        tackle.setStatus(0);
        tackleService.update(tackle);
        map.put("tackle", tackle);
        List<TackleOutLog> tackleOutLogList = tackleOutLogService.list(map);
        TackleOutLog tackleOutLog = tackleOutLogList.get(0);
        tackleOutLog.setKey(1);
        tackleOutLogService.update(tackleOutLog);
        logService.add(new Log(Log.UPDATE_ACTION, "结束医院用品出库记录" + tackleOutLog));
        resultMap.put("success", true);
        return resultMap;
    }
}
