package com.ledao.entity;

import java.util.Date;

/**
 * 医院用品出入库记录实体
 *
 * @author LeDao
 * @company
 * @create 2020-04-26 21:30
 */
public class TackleOutLog {

    /**
     * 编号
     */
    private Integer id;
    /**
     * 开始使用时间
     */
    private Date beginDate;
    /**
     * 结束使用的时间
     */
    private Date endDate;
    /**
     * 使用的用户
     */
    private User user;
    /**
     * 使用的用户id
     */
    private Integer userId;
    /**
     * 使用的设备
     */
    private Tackle tackle;
    /**
     * 使用的设备id
     */
    private Integer tackleId;
    /**
     * 使用设备的用户
     */
    private String userName;
    /**
     * 标签,用来插入结束日期
     */
    private Integer key;

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

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public Tackle getTackle() {
        return tackle;
    }

    public void setTackle(Tackle tackle) {
        this.tackle = tackle;
    }

    public Integer getTackleId() {
        return tackleId;
    }

    public void setTackleId(Integer tackleId) {
        this.tackleId = tackleId;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public Integer getKey() {
        return key;
    }

    public void setKey(Integer key) {
        this.key = key;
    }

    @Override
    public String toString() {
        return "TackleOutLog{" +
                "id=" + id +
                ", beginDate=" + beginDate +
                ", endDate=" + endDate +
                ", user=" + user +
                ", userId=" + userId +
                ", tackle=" + tackle +
                ", tackleId=" + tackleId +
                ", userName='" + userName + '\'' +
                ", key=" + key +
                '}';
    }
}
