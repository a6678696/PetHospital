package com.ledao.entity;

import lombok.Data;

/**
 * 设备实体
 *
 * @author LeDao
 * @company
 * @create 2020-03-24 18:28
 */
@Data
public class Equipment {

    /**
     * 编号
     */
    private Integer id;
    /**
     * 设备名称
     */
    private String name;
    /**
     * 设备类型
     */
    private EquipmentType equipmentType;
    /**
     * 设备类型id
     */
    private Integer equipmentTypeId;
    /**
     * 设备使用状态 0.未使用 1.使用中
     */
    private Integer status;
    /**
     * 使用设备的用户名称
     */
    private String userName;
}
