package com.ledao.controller.admin;

import com.ledao.entity.Log;
import com.ledao.entity.MedicalRecord;
import com.ledao.entity.PageBean;
import com.ledao.service.LogService;
import com.ledao.service.MedicalRecordService;
import com.ledao.util.StringUtil;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.Map;

/**
 * 后台管理病历单Controller层
 *
 * @author LeDao
 * @company
 * @create 2020-03-19 12:42
 */
@RestController
@RequestMapping("/admin/medicalRecord")
public class MedicalRecordAdminController {

    @Resource
    private MedicalRecordService medicalRecordService;

    @Resource
    private LogService logService;

    /**
     * 分页分条件查询病历单
     *
     * @param medicalRecord
     * @param page
     * @param rows
     * @return
     */
    @RequestMapping("/list")
    @RequiresPermissions(value = "病历单管理")
    public Map<String, Object> list(MedicalRecord medicalRecord, @RequestParam(value = "page", required = false) Integer page, @RequestParam(value = "rows", required = false) Integer rows) {
        PageBean pageBean = new PageBean(page, rows);
        Map<String, Object> resultMap = new HashMap<>(16);
        Map<String, Object> map = new HashMap<>(16);
        map.put("customerName", StringUtil.formatLike(medicalRecord.getCustomerName()));
        map.put("petName", StringUtil.formatLike(medicalRecord.getPetName()));
        map.put("start", pageBean.getStart());
        map.put("size", pageBean.getPageSize());
        resultMap.put("rows", medicalRecordService.list(map));
        resultMap.put("total", medicalRecordService.getCount(map));
        logService.add(new Log(Log.SEARCH_ACTION, "查询病历单"));
        return resultMap;
    }

    /**
     * 添加或修改病历单
     *
     * @param medicalRecord
     * @return
     */
    @RequestMapping("/save")
    @RequiresPermissions(value = "病历单管理")
    public Map<String, Object> save(MedicalRecord medicalRecord) {
        Map<String, Object> resultMap = new HashMap<>(16);
        int key;
        if (medicalRecord.getId() == null) {
            logService.add(new Log(Log.ADD_ACTION, "添加病历单" + medicalRecord));
            key = medicalRecordService.add(medicalRecord);
        } else {
            logService.add(new Log(Log.UPDATE_ACTION, "修改病历单" + medicalRecord));
            key = medicalRecordService.update(medicalRecord);
        }
        if (key > 0) {
            resultMap.put("success", true);
        } else {
            resultMap.put("success", false);
        }
        return resultMap;
    }

    /**
     * 删除病例单(可批量删除)
     *
     * @param ids
     * @return
     */
    @RequestMapping("/delete")
    @RequiresPermissions(value = "病历单管理")
    public Map<String, Object> delete(String ids) {
        Map<String, Object> resultMap = new HashMap<>(16);
        String[] idsStr = ids.split(",");
        for (int i = 0; i < idsStr.length; i++) {
            logService.add(new Log(Log.DELETE_ACTION, "删除文章类型" + medicalRecordService.findById(Integer.parseInt(idsStr[i]))));
            medicalRecordService.delete(Integer.parseInt(idsStr[i]));
        }
        resultMap.put("success", true);
        return resultMap;
    }
}
