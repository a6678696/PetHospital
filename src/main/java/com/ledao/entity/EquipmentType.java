package com.ledao.entity;

/**
 * 设备类型实体
 *
 * @author LeDao
 * @company
 * @create 2020-01-25 14:09
 */
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

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getImageName() {
        return imageName;
    }

    public void setImageName(String imageName) {
        this.imageName = imageName;
    }

    public String getRemarks() {
        return remarks;
    }

    public void setRemarks(String remarks) {
        this.remarks = remarks;
    }

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
