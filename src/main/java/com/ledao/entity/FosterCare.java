package com.ledao.entity;

import lombok.Data;

import java.util.Date;

/**
 * 寄养记录实体
 *
 * @author LeDao
 * @company
 * @create 2020-03-20 18:45
 */
@Data
public class FosterCare {

    /**
     * 编号
     */
    private Integer id;
    /**
     * 寄养开始时间
     */
    private Date beginDate;
    /**
     * 寄养结束时间
     */
    private Date endDate;
    /**
     * 寄养的宠物所属客户
     */
    private Customer customer;
    /**
     * 客户名称
     */
    private String customerName;
    /**
     * 寄养的宠物
     */
    private Pet pet;
    /**
     * 宠物名称
     */
    private String petName;
    /**
     * 寄养价格
     */
    private float price;
    /**
     * 付款状态 0:未付款 1:已付款
     */
    private Integer status;
    /**
     * 描述
     */
    private String description;
}
