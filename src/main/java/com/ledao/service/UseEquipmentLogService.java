package com.ledao.service;

import com.ledao.entity.UseEquipmentLog;

import java.util.List;
import java.util.Map;

/**
 * 设备使用记录Service接口
 *
 * @author LeDao
 * @company
 * @create 2020-04-04 15:28
 */
public interface UseEquipmentLogService {

    /**
     * 根据条件分页查询设备使用记录
     *
     * @param map
     * @return
     */
    List<UseEquipmentLog> list(Map<String, Object> map);

    /**
     * 获取记录数
     *
     * @param map
     * @return
     */
    Long getCount(Map<String, Object> map);

    /**
     * 添加设备使用记录
     *
     * @param useEquipmentLog
     * @return
     */
    Integer add(UseEquipmentLog useEquipmentLog);

    /**
     * 修改设备使用记录
     *
     * @param useEquipmentLog
     * @return
     */
    Integer update(UseEquipmentLog useEquipmentLog);

    /**
     * 根据id删除设备使用记录
     *
     * @param id
     * @return
     */
    Integer delete(Integer id);

    /**
     * 根据id查询实体
     *
     * @param id
     * @return
     */
    UseEquipmentLog findById(Integer id);
}
