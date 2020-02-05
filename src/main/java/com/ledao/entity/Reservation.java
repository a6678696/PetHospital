package com.ledao.entity;

import lombok.Data;

import java.util.Date;

/**
 * 客户预约单
 *
 * @author LeDao
 * @company
 * @create 2020-02-03 20:12
 */
@Data
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

}
