package com.ledao.entity;

import lombok.Data;

import java.util.Date;

/**
 * 商品报损单实体
 *
 * @author LeDao
 * @company
 * @create 2020-01-17 15:07
 */
@Data
public class DamageList {

    /**
     * 编号
     */
    private Integer id;
    /**
     * 商品报损单号
     */
    private String damageNumber;
    /**
     * 商品报损日期
     */
    private Date damageDate;
    /**
     * 起始日期 搜索用到
     */
    private Date bDamageDate;
    /**
     * 结束日期 搜索用到
     */
    private Date eDamageDate;
    /**
     * 操作员
     */
    private User user;
    /**
     * 备注
     */
    private String remarks;

}
