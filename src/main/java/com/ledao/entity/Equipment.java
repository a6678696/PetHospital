package com.ledao.entity;

/**
 * 设备实体
 *
 * @author LeDao
 * @company
 * @create 2020-03-24 18:28
 */
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

    public EquipmentType getEquipmentType() {
        return equipmentType;
    }

    public void setEquipmentType(EquipmentType equipmentType) {
        this.equipmentType = equipmentType;
    }

    public Integer getEquipmentTypeId() {
        return equipmentTypeId;
    }

    public void setEquipmentTypeId(Integer equipmentTypeId) {
        this.equipmentTypeId = equipmentTypeId;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    @Override
    public String toString() {
        return "Equipment{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", equipmentType=" + equipmentType +
                ", equipmentTypeId=" + equipmentTypeId +
                ", status=" + status +
                ", userName='" + userName + '\'' +
                '}';
    }
}
