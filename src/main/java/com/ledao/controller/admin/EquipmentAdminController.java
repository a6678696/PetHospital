package com.ledao.controller.admin;

import com.ledao.entity.Equipment;
import com.ledao.entity.EquipmentType;
import com.ledao.entity.Log;
import com.ledao.entity.PageBean;
import com.ledao.service.EquipmentService;
import com.ledao.service.EquipmentTypeService;
import com.ledao.service.LogService;
import com.ledao.util.StringUtil;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 后台设备Controller层
 *
 * @author LeDao
 * @company
 * @create 2020-03-25 10:13
 */
@RestController
@RequestMapping("/admin/equipment")
public class EquipmentAdminController {

    @Resource
    private EquipmentService equipmentService;

    @Resource
    private EquipmentTypeService equipmentTypeService;

    @Resource
    private LogService logService;

    /**
     * 下拉框模糊查询
     *
     * @param q
     * @return
     */
    @RequestMapping("/comboList")
    @RequiresPermissions(value = "设备使用记录管理")
    public List<Equipment> comboList(String q) {
        if (q == null) {
            q = "";
        }
        return equipmentService.findByName(StringUtil.formatLike(q));
    }

    /**
     * 分页分条件查询设备信息
     *
     * @param equipment
     * @param page
     * @param rows
     * @return
     */
    @RequestMapping("/list")
    @RequiresPermissions(value = "设备管理")
    public Map<String, Object> list(Equipment equipment, @RequestParam(value = "page", required = false) Integer page, @RequestParam(value = "rows", required = false) Integer rows) {
        PageBean pageBean = new PageBean(page, rows);
        Map<String, Object> resultMap = new HashMap<>(16);
        Map<String, Object> map = new HashMap<>(16);
        map.put("name", StringUtil.formatLike(equipment.getName()));
        map.put("equipmentTypeId", equipment.getEquipmentTypeId());
        map.put("start", pageBean.getStart());
        map.put("size", pageBean.getPageSize());
        resultMap.put("rows", equipmentService.list(map));
        resultMap.put("total", equipmentService.getCount(map));
        logService.add(new Log(Log.SEARCH_ACTION, "查询设备信息"));
        return resultMap;
    }

    /**
     * 添加或修改设备
     *
     * @param equipment
     * @return
     */
    @RequestMapping("/save")
    @RequiresPermissions(value = "设备管理")
    public Map<String, Object> save(Equipment equipment) {
        Map<String, Object> resultMap = new HashMap<>(16);
        int key;
        if (equipmentService.getCountByName(equipment.getName())>0) {
            resultMap.put("success", false);
            resultMap.put("errorInfo", "该设备名已存在,请重新输入!!");
            return resultMap;
        }
        equipment.setEquipmentType(equipmentTypeService.findById(equipment.getEquipmentTypeId()));
        if (equipment.getId() == null) {
            key = equipmentService.add(equipment);
            logService.add(new Log(Log.ADD_ACTION, "添加设备类型信息" + equipment));
        } else {
            key = equipmentService.update(equipment);
            logService.add(new Log(Log.UPDATE_ACTION, "修改设备类型信息" + equipment));
        }
        if (key > 0) {
            resultMap.put("success", true);
        } else {
            resultMap.put("success", false);
        }
        return resultMap;
    }

    /**
     * 删除设备信息(可批量删除)
     *
     * @param ids
     * @return
     */
    @RequestMapping("/delete")
    @RequiresPermissions(value = "设备管理")
    public Map<String, Object> delete(String ids) {
        Map<String, Object> resultMap = new HashMap<>(16);
        String[] idsStr = ids.split(",");
        for (int i = 0; i < idsStr.length; i++) {
            int id = Integer.parseInt(idsStr[i]);
            logService.add(new Log(Log.DELETE_ACTION, "删除设备信息" + equipmentService.findById(id)));
            equipmentService.delete(id);
        }
        resultMap.put("success", true);
        return resultMap;
    }

    /**
     * 分页分条件查询未使用的设备信息
     *
     * @param equipment
     * @param page
     * @param rows
     * @return
     */
    @RequestMapping("/listNoUse")
    @RequiresPermissions(value = "设备使用管理")
    public Map<String, Object> listNoUse(Equipment equipment, @RequestParam(value = "page", required = false) Integer page, @RequestParam(value = "rows", required = false) Integer rows) {
        PageBean pageBean = new PageBean(page, rows);
        Map<String, Object> resultMap = new HashMap<>(16);
        Map<String, Object> map = new HashMap<>(16);
        map.put("status", 0);
        map.put("name", StringUtil.formatLike(equipment.getName()));
        map.put("start", pageBean.getStart());
        map.put("size", pageBean.getPageSize());
        resultMap.put("rows", equipmentService.list(map));
        resultMap.put("total", equipmentService.getCount(map));
        logService.add(new Log(Log.SEARCH_ACTION, "查询空闲的设备信息"));
        return resultMap;
    }

    /**
     * 分页分条件查询使用中的设备信息
     *
     * @param equipment
     * @param page
     * @param rows
     * @return
     */
    @RequestMapping("/listIsUse")
    @RequiresPermissions(value = "设备使用管理")
    public Map<String, Object> listIsUse(Equipment equipment, @RequestParam(value = "page", required = false) Integer page, @RequestParam(value = "rows", required = false) Integer rows) {
        PageBean pageBean = new PageBean(page, rows);
        Map<String, Object> resultMap = new HashMap<>(16);
        Map<String, Object> map = new HashMap<>(16);
        map.put("status", 1);
        map.put("name", StringUtil.formatLike(equipment.getName()));
        map.put("start", pageBean.getStart());
        map.put("size", pageBean.getPageSize());
        resultMap.put("rows", equipmentService.list(map));
        resultMap.put("total", equipmentService.getCount(map));
        logService.add(new Log(Log.SEARCH_ACTION, "查询使用的设备信息"));
        return resultMap;
    }
}
