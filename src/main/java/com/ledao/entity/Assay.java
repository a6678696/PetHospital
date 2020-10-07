package com.ledao.entity;

import java.util.Date;

/**
 * 化验记录
 *
 * @author LeDao
 * @company
 * @create 2020-03-18 23:39
 */
public class Assay {

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
     * 化验记录描述
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

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    @Override
    public String toString() {
        return "Assay{" +
                "id=" + id +
                ", createDate=" + createDate +
                ", customerName='" + customerName + '\'' +
                ", petName='" + petName + '\'' +
                ", pet=" + pet +
                ", content='" + content + '\'' +
                '}';
    }
}
