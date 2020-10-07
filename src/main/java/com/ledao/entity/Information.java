package com.ledao.entity;

import java.util.Date;

/**
 * 客户消息
 *
 * @author LeDao
 * @company
 * @create 2020-05-01 21:56
 */
public class Information {

    /**
     * 编号
     */
    private Integer id;
    /**
     * 内容
     */
    private String content;
    /**
     * 发送日期
     */
    private Date sendDate;
    /**
     * 当前状态 0.未读 1.已读
     */
    private Integer isRead;
    /**
     * 客户实体
     */
    private Customer customer;
    /**
     * 医院用户实体
     */
    private User user;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public Date getSendDate() {
        return sendDate;
    }

    public void setSendDate(Date sendDate) {
        this.sendDate = sendDate;
    }

    public Integer getIsRead() {
        return isRead;
    }

    public void setIsRead(Integer isRead) {
        this.isRead = isRead;
    }

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    @Override
    public String toString() {
        return "Information{" +
                "id=" + id +
                ", content='" + content + '\'' +
                ", sendDate=" + sendDate +
                ", isRead=" + isRead +
                ", customer=" + customer +
                ", user=" + user +
                '}';
    }
}
