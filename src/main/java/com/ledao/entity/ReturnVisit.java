package com.ledao.entity;

import java.util.Date;

/**
 * 客户回访记录
 *
 * @author LeDao
 * @company
 * @create 2020-03-18 23:39
 */
public class ReturnVisit {

    /**
     * 编号
     */
    private Integer id;
    /**
     * 创建时间
     */
    private Date createDate;
    /**
     * 客户真实姓名
     */
    private String customerName;
    /**
     * 客户的宠物名称
     */
    private String petName;
    /**
     * 宠物实体
     */
    private Pet pet;
    /**
     * 客户满意度(1星到5星)
     */
    private Integer satisfaction;
    /**
     * 客户回访记录描述
     */
    private String content;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Date getCreateDate() {
        return createDate;
    }

    public void setCreateDate(Date createDate) {
        this.createDate = createDate;
    }

    public String getCustomerName() {
        return customerName;
    }

    public void setCustomerName(String customerName) {
        this.customerName = customerName;
    }

    public String getPetName() {
        return petName;
    }

    public void setPetName(String petName) {
        this.petName = petName;
    }

    public Pet getPet() {
        return pet;
    }

    public void setPet(Pet pet) {
        this.pet = pet;
    }

    public Integer getSatisfaction() {
        return satisfaction;
    }

    public void setSatisfaction(Integer satisfaction) {
        this.satisfaction = satisfaction;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    @Override
    public String toString() {
        return "ReturnVisit{" +
                "id=" + id +
                ", createDate=" + createDate +
                ", customerName='" + customerName + '\'' +
                ", petName='" + petName + '\'' +
                ", pet=" + pet +
                ", satisfaction=" + satisfaction +
                ", content='" + content + '\'' +
                '}';
    }
}
