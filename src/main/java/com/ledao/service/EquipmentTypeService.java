package com.ledao.service;

import com.ledao.entity.EquipmentType;

import java.util.List;
import java.util.Map;

/**
 * 设备类型Service接口
 *
 * @author LeDao
 * @company
 * @create 2020-01-26 00:17
 */
public interface EquipmentTypeService {

    /**
     * 分页条件查询设备类型信息
     *
     * @param map
     * @return
     */
    List<EquipmentType> list(Map<String, Object> map);

    /**
     * 获取记录数
     *
     * @param map
     * @return
     */
    Long getCount(Map<String, Object> map);

    /**
     * 添加设备类型信息
     *
     * @param equipmentType
     * @return
     */
    Integer add(EquipmentType equipmentType);

    /**
     * 修改设备类型信息
     *
     * @param equipmentType
     * @return
     */
    Integer update(EquipmentType equipmentType);

    /**
     * 删除设备类型信息
     *
     * @param id
     * @return
     */
    Integer delete(Integer id);

    /**
     * 根据id查找实体
     *
     * @param id
     * @return
     */
    EquipmentType findById(Integer id);

    /**
     * 根据名称查找实体
     *
     * @param name
     * @return
     */
    List<EquipmentType> findByName(String name);
}
