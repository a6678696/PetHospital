package com.ledao.entity;

import lombok.Data;

/**
 * 供应商实体
 *
 * @author LeDao
 * @company
 * @create 2020-01-17 15:43
 */
@Data
public class Supplier {

    /**
     *编号
     */
    private Integer id;
    /**
     *供应商名称
     */
    private String name;
    /**
     *联系人
     */
    private String contact;
    /**
     *联系电话
     */
    private String number;
    /**
     *联系地址
     */
    private String address;
    /**
     *备注
     */
    private String remarks;

    @Override
    public String toString() {
        return "--{" +
                "编号=" + id +
                ", 供应商名称='" + name + '\'' +
                ", 联系人='" + contact + '\'' +
                ", 联系电话='" + number + '\'' +
                ", 联系地址='" + address + '\'' +
                '}';
    }
}
