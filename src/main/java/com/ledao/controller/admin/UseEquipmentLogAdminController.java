package com.ledao.controller.admin;

import com.ledao.entity.*;
import com.ledao.service.EquipmentService;
import com.ledao.service.LogService;
import com.ledao.service.UseEquipmentLogService;
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
 * 后台管理设备使用记录Controller层
 *
 * @author LeDao
 * @company
 * @create 2020-04-04 15:36
 */
@RestController
@RequestMapping("/admin/useEquipmentLog")
public class UseEquipmentLogAdminController {

    @Resource
    private UseEquipmentLogService useEquipmentLogService;

    @Resource
    private EquipmentService equipmentService;

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
     * 分页查询设备使用记录
     *
     * @param useEquipmentLog
     * @param page
     * @param rows
     * @return
     */
    @RequestMapping("/list")
    @RequiresPermissions(value = "设备使用记录管理")
    public Map<String, Object> list(UseEquipmentLog useEquipmentLog, @RequestParam(value = "page", required = false) Integer page, @RequestParam(value = "rows", required = false) Integer rows) {
        PageBean pageBean = new PageBean(page, rows);
        Map<String, Object> resultMap = new HashMap<>(16);
        Map<String, Object> map = new HashMap<>(16);
        map.put("user", userService.findById(useEquipmentLog.getUserId()));
        map.put("equipment", equipmentService.findById(useEquipmentLog.getEquipmentId()));
        map.put("start", pageBean.getStart());
        map.put("size", pageBean.getPageSize());
        resultMap.put("rows", useEquipmentLogService.list(map));
        resultMap.put("total", useEquipmentLogService.getCount(map));
        logService.add(new Log(Log.SEARCH_ACTION, "查询设备使用记录信息"));
        return resultMap;
    }

    /**
     * 添加或修改设备使用记录
     *
     * @param useEquipmentLog
     * @return
     */
    @RequestMapping("/save")
    @RequiresPermissions(value = "设备使用记录管理")
    public Map<String, Object> save(UseEquipmentLog useEquipmentLog) {
        Map<String, Object> resultMap = new HashMap<>(16);
        if (useEquipmentLog.getId() == null) {
            useEquipmentLogService.add(useEquipmentLog);
            logService.add(new Log(Log.ADD_ACTION, "添加设备使用记录" + useEquipmentLog));
        } else {
            useEquipmentLog.setUser(userService.findById(useEquipmentLog.getUserId()));
            useEquipmentLog.setEquipment(equipmentService.findById(useEquipmentLog.getEquipmentId()));
            useEquipmentLogService.update(useEquipmentLog);
            logService.add(new Log(Log.UPDATE_ACTION, "修改设备使用记录" + useEquipmentLog));
        }
        resultMap.put("success", true);
        return resultMap;
    }

    /**
     * 删除设备使用记录
     *
     * @param ids
     * @return
     */
    @RequestMapping("/delete")
    @RequiresPermissions(value = "设备使用记录管理")
    public Map<String, Object> delete(String ids) {
        Map<String, Object> resultMap = new HashMap<>(16);
        String[] idsStr = ids.split(",");
        for (int i = 0; i < idsStr.length; i++) {
            int id = Integer.parseInt(idsStr[i]);
            logService.add(new Log(Log.DELETE_ACTION, "删除设备使用记录" + useEquipmentLogService.findById(id)));
            useEquipmentLogService.delete(id);
        }
        resultMap.put("success", true);
        return resultMap;
    }

    /**
     * 开始一个设备使用记录
     *
     * @param id
     * @param equipment
     * @return
     */
    @RequestMapping("/beginUseEquipmentLog")
    @RequiresPermissions(value = "设备使用管理")
    public Map<String, Object> beginUseEquipmentLog(Integer id, Equipment equipment) {
        Map<String, Object> resultMap = new HashMap<>(16);
        User user = userService.findByTrueName(equipment.getUserName());
        if (user == null) {
            resultMap.put("success", false);
            resultMap.put("errorInfo", "您输入的用户的真实姓名不存在,请核实!!");
            return resultMap;
        }
        Equipment equipmentSave = equipmentService.findById(id);
        equipmentSave.setStatus(1);
        equipmentService.update(equipmentSave);
        UseEquipmentLog useEquipmentLog = new UseEquipmentLog();
        useEquipmentLog.setEquipment(equipmentSave);
        useEquipmentLog.setUser(user);
        useEquipmentLogService.add(useEquipmentLog);
        logService.add(new Log(Log.ADD_ACTION, "添加设备使用记录" + useEquipmentLog));
        resultMap.put("success", true);
        return resultMap;
    }

    /**
     * 结束一个设备使用记录
     *
     * @param equipmentTypeId
     * @return
     */
    @RequestMapping("/endUseEquipmentLog")
    @RequiresPermissions(value = "设备使用管理")
    public Map<String, Object> endUseEquipmentLog(Integer equipmentTypeId) {
        Map<String, Object> resultMap = new HashMap<>(16);
        Map<String, Object> map = new HashMap<>(16);
        Equipment equipment = equipmentService.findById(equipmentTypeId);
        equipment.setStatus(0);
        equipmentService.update(equipment);
        map.put("equipment", equipment);
        List<UseEquipmentLog> useEquipmentLogList = useEquipmentLogService.list(map);
        UseEquipmentLog useEquipmentLog = useEquipmentLogList.get(0);
        useEquipmentLog.setKey(1);
        useEquipmentLogService.update(useEquipmentLog);
        logService.add(new Log(Log.UPDATE_ACTION, "结束设备使用记录" + useEquipmentLog));
        resultMap.put("success", true);
        return resultMap;
    }
}
