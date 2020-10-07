package com.ledao.entity;

import java.util.Date;

/**
 * 客户建议或反馈
 *
 * @author LeDao
 * @company
 * @create 2020-03-07 20:58
 */
public class Suggestion {

    /**
     * 编号
     */
    private Integer id;
    /**
     * 创建时间
     */
    private Date createDate;
    /**
     * 内容
     */
    private String content;
    /**
     * 提建议的客户
     */
    private Customer customer;
    /**
     * 答复的人
     */
    private User user;
    /**
     * 答复的内容
     */
    private String reply;

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

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
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

    public String getReply() {
        return reply;
    }

    public void setReply(String reply) {
        this.reply = reply;
    }

    @Override
    public String toString() {
        return "Suggestion{" +
                "id=" + id +
                ", createDate=" + createDate +
                ", content='" + content + '\'' +
                ", customer=" + customer +
                ", user=" + user +
                ", reply='" + reply + '\'' +
                '}';
    }
}
