package com.ledao.entity;

import lombok.Data;

import java.util.Date;

/**
 * 客户问诊实体类
 *
 * @author LeDao
 * @company
 * @create 2020-03-10 22:08
 */
@Data
public class Inquiry {

    /**
     * 编号
     */
    private Integer id;
    /**
     * 问诊时间
     */
    private Date createDate;
    /**
     * 问诊用的客户
     */
    private Customer customer;
    /**
     * 客户的宠物
     */
    private Pet pet;
    /**
     * 客户宠物id
     */
    private Integer petId;
    /**
     * 问诊内容
     */
    private String content;
    /**
     * 病情图片
     */
    private String imageName;
    /**
     * 接诊的医生
     */
    private User user;
    /**
     * 医生诊断内容
     */
    private String reply;
    /**
     * 医疗价格区间
     */
    private String price;
    /**
     * 问诊状态
     */
    private Integer status;
}
