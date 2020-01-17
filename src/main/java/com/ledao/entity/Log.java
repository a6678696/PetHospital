package com.ledao.entity;

import lombok.Data;

import java.util.Date;

/**
 * 日志实体
 *
 * @author LeDao
 * @company
 * @create 2020-01-17 15:16
 */
@Data
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
}
