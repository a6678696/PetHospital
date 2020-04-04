package com.ledao.mapper;

import com.ledao.entity.Equipment;
import com.ledao.entity.Equipment;
import com.ledao.entity.EquipmentType;

import java.util.List;
import java.util.Map;

/**
 * 设备Mapper接口
 *
 * @author LeDao
 * @company
 * @create 2020-03-24 18:31
 */
public interface EquipmentMapper {

    /**
     * 分页条件查询设备信息
     *
     * @param map
     * @return
     */
    List<Equipment> list(Map<String, Object> map);

    /**
     * 获取记录数
     *
     * @param map
     * @return
     */
    Long getCount(Map<String, Object> map);

    /**
     * 添加设备信息
     *
     * @param equipment
     * @return
     */
    Integer add(Equipment equipment);

    /**
     * 修改设备信息
     *
     * @param equipment
     * @return
     */
    Integer update(Equipment equipment);

    /**
     * 删除设备信息
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
    Equipment findById(Integer id);

    /**
     * 根据设备名称查找设备
     *
     * @param name
     * @return
     */
    List<Equipment> findByName(String name);

    /**
     * 根据设备名查询记录数
     *
     * @param name
     * @return
     */
    Long getCountByName(String name);

    /**
     * 根据设备类型id查询设备记录数
     *
     * @param equipmentTypeId
     * @return
     */
    Long getCountByEquipmentTypeId(Integer equipmentTypeId);
}
