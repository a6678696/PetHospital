package com.ledao.entity;

import java.util.Date;

/**
 * 寄养记录实体
 *
 * @author LeDao
 * @company
 * @create 2020-03-20 18:45
 */
public class FosterCare {

    /**
     * 编号
     */
    private Integer id;
    /**
     * 寄养开始时间
     */
    private Date beginDate;
    /**
     * 寄养结束时间
     */
    private Date endDate;
    /**
     * 寄养的宠物所属客户
     */
    private Customer customer;
    /**
     * 客户名称
     */
    private String customerName;
    /**
     * 寄养的宠物
     */
    private Pet pet;
    /**
     * 宠物名称
     */
    private String petName;
    /**
     * 寄养价格
     */
    private float price;
    /**
     * 付款状态 0:未付款 1:已付款
     */
    private Integer status;
    /**
     * 描述
     */
    private String description;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Date getBeginDate() {
        return beginDate;
    }

    public void setBeginDate(Date beginDate) {
        this.beginDate = beginDate;
    }

    public Date getEndDate() {
        return endDate;
    }

    public void setEndDate(Date endDate) {
        this.endDate = endDate;
    }

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    public String getCustomerName() {
        return customerName;
    }

    public void setCustomerName(String customerName) {
        this.customerName = customerName;
    }

    public Pet getPet() {
        return pet;
    }

    public void setPet(Pet pet) {
        this.pet = pet;
    }

    public String getPetName() {
        return petName;
    }

    public void setPetName(String petName) {
        this.petName = petName;
    }

    public float getPrice() {
        return price;
    }

    public void setPrice(float price) {
        this.price = price;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @Override
    public String toString() {
        return "FosterCare{" +
                "id=" + id +
                ", beginDate=" + beginDate +
                ", endDate=" + endDate +
                ", customer=" + customer +
                ", customerName='" + customerName + '\'' +
                ", pet=" + pet +
                ", petName='" + petName + '\'' +
                ", price=" + price +
                ", status=" + status +
                ", description='" + description + '\'' +
                '}';
    }
}
