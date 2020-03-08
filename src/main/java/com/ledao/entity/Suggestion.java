package com.ledao.entity;

import lombok.Data;

import java.util.Date;

/**
 * 客户建议或反馈
 *
 * @author LeDao
 * @company
 * @create 2020-03-07 20:58
 */
@Data
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
}
