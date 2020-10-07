package com.ledao.controller.admin;

import com.ledao.entity.ArticleType;
import com.ledao.entity.EquipmentType;
import com.ledao.entity.Log;
import com.ledao.entity.PageBean;
import com.ledao.run.StartupRunner;
import com.ledao.service.EquipmentService;
import com.ledao.service.EquipmentTypeService;
import com.ledao.service.LogService;
import com.ledao.util.DateUtil;
import com.ledao.util.StringUtil;
import org.apache.commons.io.FileUtils;
import org.apache.shiro.authz.annotation.Logical;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import javax.annotation.Resource;
import java.io.File;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 后台管理设备类型Controller
 *
 * @author LeDao
 * @company
 * @create 2020-01-25 15:01
 */
@RestController
@RequestMapping("/admin/equipmentType")
public class EquipmentTypeAdminController {

    @Value("${equipmentTypeImageFilePath}")
    private String equipmentTypeImageFilePath;

    @Resource
    private EquipmentTypeService equipmentTypeService;

    @Resource
    private EquipmentService equipmentService;

    @Resource
    private LogService logService;

    @Resource
    private StartupRunner startupRunner;

    /**
     * 下拉框模糊查询
     *
     * @param q
     * @return
     */
    @RequestMapping("/comboList")
    @RequiresPermissions(value = "设备管理")
    public List<EquipmentType> comboList(String q) {
        if (q == null) {
            q = "";
        }
        return equipmentTypeService.findByName(StringUtil.formatLike(q));
    }

    /**
     * 分页查询设备类型信息
     *
     * @param page
     * @param rows
     * @return
     */
    @RequestMapping("/list")
    @RequiresPermissions(value = "设备类型管理")
    public Map<String, Object> list(EquipmentType equipmentType,@RequestParam(value = "page", required = false) Integer page, @RequestParam(value = "rows", required = false) Integer rows) {
        PageBean pageBean = new PageBean(page, rows);
        Map<String, Object> resultMap = new HashMap<>(16);
        Map<String, Object> map = new HashMap<>(16);
        map.put("name", StringUtil.formatLike(equipmentType.getName()));
        map.put("start", pageBean.getStart());
        map.put("size", pageBean.getPageSize());
        resultMap.put("rows", equipmentTypeService.list(map));
        resultMap.put("total", equipmentTypeService.getCount(map));
        logService.add(new Log(Log.SEARCH_ACTION, "查询设备类型信息"));
        return resultMap;
    }

    /**
     * 添加或修改设备类型信息
     *
     * @param equipmentType
     * @return
     */
    @RequestMapping("/save")
    @RequiresPermissions(value = "设备类型管理")
    public Map<String, Object> save(EquipmentType equipmentType, @RequestParam("equipmentTypeImage") MultipartFile file) throws Exception {
        Map<String, Object> resultMap = new HashMap<>(16);
        if (!file.isEmpty()) {
            // 获取上传的文件名
            String fileName = file.getOriginalFilename();
            // 获取文件的后缀
            String suffixName = fileName.substring(fileName.lastIndexOf("."));
            String newFileName = DateUtil.getCurrentDateStr2() + suffixName;
            FileUtils.copyInputStreamToFile(file.getInputStream(), new File(equipmentTypeImageFilePath + newFileName));
            if (equipmentType.getId() != null) {
                FileUtils.deleteQuietly(new File(equipmentTypeImageFilePath + equipmentTypeService.findById(equipmentType.getId()).getImageName()));
            }
            equipmentType.setImageName(newFileName);
        }
        int key;
        if (equipmentType.getId() == null) {
            key = equipmentTypeService.add(equipmentType);
            logService.add(new Log(Log.ADD_ACTION, "添加设备类型信息" + equipmentType));
        } else {
            key = equipmentTypeService.update(equipmentType);
            logService.add(new Log(Log.UPDATE_ACTION, "修改设备类型信息" + equipmentType));
        }
        if (key > 0) {
            resultMap.put("success", true);
            startupRunner.loadData();
        } else {
            resultMap.put("success", false);
        }
        return resultMap;
    }

    /**
     * 删除设备类型信息
     *
     * @param ids
     * @return
     */
    @RequestMapping("/delete")
    @RequiresPermissions(value = "设备类型管理")
    public Map<String, Object> delete(String ids){
        Map<String, Object> resultMap = new HashMap<>(16);
        String[] idsStr = ids.split(",");
        for (int i = 0; i < idsStr.length; i++) {
            int id = Integer.parseInt(idsStr[i]);
            if (equipmentService.getCountByEquipmentTypeId(id) == 0) {
                logService.add(new Log(Log.DELETE_ACTION, "删除设备类型信息" + equipmentTypeService.findById(id)));
                if (equipmentTypeService.findById(id).getImageName() != null) {
                    FileUtils.deleteQuietly(new File(equipmentTypeImageFilePath + equipmentTypeService.findById(equipmentTypeService.findById(id).getId()).getImageName()));
                }
                equipmentTypeService.delete(id);
            } else {
                resultMap.put("success", false);
                resultMap.put("errorInfo", "该设备类型下有设备信息,不能删除!!");
                return resultMap;
            }
        }
        startupRunner.loadData();
        resultMap.put("success", true);
        return resultMap;
    }
}
