package com.ledao.entity;

import java.util.Date;

/**
 * 客户问诊实体类
 *
 * @author LeDao
 * @company
 * @create 2020-03-10 22:08
 */
public class Inquiry {

    /**
     * 编号
     */
    private Integer id;
    /**
     * 问诊时间
     */
    private Date createDate;
    /**
     * 问诊用的客户
     */
    private Customer customer;
    /**
     * 客户的宠物
     */
    private Pet pet;
    /**
     * 客户宠物id
     */
    private Integer petId;
    /**
     * 问诊内容
     */
    private String content;
    /**
     * 病情图片
     */
    private String imageName;
    /**
     * 接诊的医生
     */
    private User user;
    /**
     * 医生诊断内容
     */
    private String reply;
    /**
     * 医疗价格区间
     */
    private String price;
    /**
     * 问诊状态
     */
    private Integer status;

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

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getImageName() {
        return imageName;
    }

    public void setImageName(String imageName) {
        this.imageName = imageName;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public String getReply() {
        return reply;
    }

    public void setReply(String reply) {
        this.reply = reply;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    @Override
    public String toString() {
        return "Inquiry{" +
                "id=" + id +
                ", createDate=" + createDate +
                ", customer=" + customer +
                ", pet=" + pet +
                ", petId=" + petId +
                ", content='" + content + '\'' +
                ", imageName='" + imageName + '\'' +
                ", user=" + user +
                ", reply='" + reply + '\'' +
                ", price='" + price + '\'' +
                ", status=" + status +
                '}';
    }
}
