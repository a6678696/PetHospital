package com.ledao.entity;

import lombok.Data;

/**
 * 设备类型实体
 *
 * @author LeDao
 * @company
 * @create 2020-01-25 14:09
 */
@Data
public class EquipmentType {

    /**
     * 编号
     */
    private Integer id;
    /**
     * 名称
     */
    private String name;
    /**
     * 图片
     */
    private String imageName;
    /**
     * 备注
     */
    private String remarks;

    @Override
    public String toString() {
        return "--{" +
                "编号=" + id +
                ", 名称=" + name +
                ", 轮播图图片='" + imageName + '\'' +
                ", 备注='" + remarks + '\'' +
                '}';
    }
}
