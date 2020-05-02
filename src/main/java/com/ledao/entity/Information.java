package com.ledao.entity;

import lombok.Data;

import java.util.Date;

/**
 * 客户消息
 *
 * @author LeDao
 * @company
 * @create 2020-05-01 21:56
 */
@Data
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
}
