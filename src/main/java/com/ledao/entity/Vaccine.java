package com.ledao.entity;

import lombok.Data;

import java.util.Date;

/**
 * 疫苗注射记录
 *
 * @author LeDao
 * @company
 * @create 2020-03-18 23:39
 */
@Data
public class Vaccine {

    /**
     * 编号
     */
    private Integer id;
    /**
     * 创建时间
     */
    private Date createDate;
    /**
     * 客户真实姓名
     */
    private String customerName;
    /**
     * 客户的宠物名称
     */
    private String petName;
    /**
     * 宠物实体
     */
    private Pet pet;
    /**
     * 疫苗注射记录描述
     */
    private String content;
}
