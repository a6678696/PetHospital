package com.ledao.entity;

import lombok.Data;

/**
 * 客户宠物实体
 *
 * @author LeDao
 * @company
 * @create 2020-02-02 14:22
 */
@Data
public class Pet {

    /**
     * 编号
     */
    private Integer id;
    /**
     * 名称
     */
    private String name;
    /**
     * 年龄
     */
    private Integer age;
    /**
     * 宠物类型
     */
    private String typeName;
    /**
     * 宠物头像
     */
    private String imageName;
    /**
     * 所属客户
     */
    private Customer customer;
}
