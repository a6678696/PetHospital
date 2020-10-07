package com.ledao.entity;

import java.util.Date;

/**
 * 客户预约单
 *
 * @author LeDao
 * @company
 * @create 2020-02-03 20:12
 */
public class Reservation {

    /**
     * 编号
     */
    private Integer id;
    /**
     * 预约类型(预约医生、预约美容师)
     */
    private String type;
    /**
     * 要预约的客户
     */
    private Customer customer;
    /**
     * 要预约的宠物
     */
    private Pet pet;
    /**
     * 宠物id添加或修改预约单时用到
     */
    private Integer petId;
    /**
     * 传入的日期
     */
    private String date;
    /**
     * 预约时间
     */
    private Date reserveDate;
    /**
     * 小时
     */
    private Integer hour;
    /**
     * 分钟
     */
    private Integer minute;
    /**
     * 预约单创建时间
     */
    private Date createDate;
    /**
     * 预约描述(预约医生时可以输入病情描述)
     */
    private String description;
    /**
     * 接受预约的医生或美容师
     */
    private User user;
    /**
     * 状态(0.未处理 1.预约成功 2.预约失败)
     */
    private Integer status;
    /**
     * 备注(如果预约不成功可以输入原因)
     */
    private String remarks;
    /**
     * 判断预约单是否被取消,用来清空预约单中的接受预约人
     */
    private Integer isCancel;
    /**
     * 是否提醒客户 0.未提醒 1.已提醒
     */
    private Integer isRemind;
    /**
     *起始日期 搜索用到
     */
    private Date bSaleDate;
    /**
     *结束日期 搜索用到
     */
    private Date eSaleDate;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    public Pet getPet() {
        return pet;
    }

    public void setPet(Pet pet) {
        this.pet = pet;
    }

    public Integer getPetId() {
        return petId;
    }

    public void setPetId(Integer petId) {
        this.petId = petId;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public Date getReserveDate() {
        return reserveDate;
    }

    public void setReserveDate(Date reserveDate) {
        this.reserveDate = reserveDate;
    }

    public Integer getHour() {
        return hour;
    }

    public void setHour(Integer hour) {
        this.hour = hour;
    }

    public Integer getMinute() {
        return minute;
    }

    public void setMinute(Integer minute) {
        this.minute = minute;
    }

    public Date getCreateDate() {
        return createDate;
    }

    public void setCreateDate(Date createDate) {
        this.createDate = createDate;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public String getRemarks() {
        return remarks;
    }

    public void setRemarks(String remarks) {
        this.remarks = remarks;
    }

    public Integer getIsCancel() {
        return isCancel;
    }

    public void setIsCancel(Integer isCancel) {
        this.isCancel = isCancel;
    }

    public Integer getIsRemind() {
        return isRemind;
    }

    public void setIsRemind(Integer isRemind) {
        this.isRemind = isRemind;
    }

    public Date getbSaleDate() {
        return bSaleDate;
    }

    public void setbSaleDate(Date bSaleDate) {
        this.bSaleDate = bSaleDate;
    }

    public Date geteSaleDate() {
        return eSaleDate;
    }

    public void seteSaleDate(Date eSaleDate) {
        this.eSaleDate = eSaleDate;
    }

    @Override
    public String toString() {
        return "Reservation{" +
                "id=" + id +
                ", type='" + type + '\'' +
                ", customer=" + customer +
                ", pet=" + pet +
                ", petId=" + petId +
                ", date='" + date + '\'' +
                ", reserveDate=" + reserveDate +
                ", hour=" + hour +
                ", minute=" + minute +
                ", createDate=" + createDate +
                ", description='" + description + '\'' +
                ", user=" + user +
                ", status=" + status +
                ", remarks='" + remarks + '\'' +
                ", isCancel=" + isCancel +
                ", isRemind=" + isRemind +
                ", bSaleDate=" + bSaleDate +
                ", eSaleDate=" + eSaleDate +
                '}';
    }
}
