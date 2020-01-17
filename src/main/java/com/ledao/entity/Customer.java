package com.ledao.entity;

import lombok.Data;

/**
 * 客户实体
 *
 * @author LeDao
 * @company
 * @create 2020-01-17 15:01
 */
@Data
public class Customer {

    /**
     * 编号
     */
    private Integer id;
    /**
     * 客户名称
     */
    private String name;
    /**
     * 联系人
     */
    private String contact;
    /**
     * 联系电话
     */
    private String number;
    /**
     * 联系地址
     */
    private String address;
    /**
     * 备注
     */
    private String remarks;
}
