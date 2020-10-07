package com.ledao.entity;

import com.fasterxml.jackson.annotation.JsonFormat;

import java.util.Date;

/**
 * 日志实体
 *
 * @author LeDao
 * @company
 * @create 2020-01-17 15:16
 */
public class Log {

    public final static String LOGIN_ACTION="登录操作";
    public final static String LOGOUT_ACTION="注销操作";
    public final static String SEARCH_ACTION="查询操作";
    public final static String UPDATE_ACTION="更新操作";
    public final static String ADD_ACTION="添加操作";
    public final static String DELETE_ACTION="删除操作";

    /**
     * 编号
     */
    private Integer id;
    /**
     * 日志类型
     */
    private String type;
    /**
     * 操作用户
     */
    private User user;
    /**
     * 操作内容
     */
    private String content;
    /**
     * 操作日期时间
     */
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private Date time;
    /**
     * 起始时间 搜索用到
     */
    private Date bTime;
    /**
     * 结束时间 搜索用到
     */
    private Date eTime;

    public Log() {
    }

    public Log(String type, String content) {
        this.type = type;
        this.content = content;
    }

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

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public Date getTime() {
        return time;
    }

    public void setTime(Date time) {
        this.time = time;
    }

    public Date getbTime() {
        return bTime;
    }

    public void setbTime(Date bTime) {
        this.bTime = bTime;
    }

    public Date geteTime() {
        return eTime;
    }

    public void seteTime(Date eTime) {
        this.eTime = eTime;
    }

    @Override
    public String toString() {
        return "Log{" +
                "id=" + id +
                ", type='" + type + '\'' +
                ", user=" + user +
                ", content='" + content + '\'' +
                ", time=" + time +
                ", bTime=" + bTime +
                ", eTime=" + eTime +
                '}';
    }
}
