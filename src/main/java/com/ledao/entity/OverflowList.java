package com.ledao.entity;

import lombok.Data;

import java.beans.Transient;
import java.util.Date;

/**
 * 商品报溢单实体
 *
 * @author LeDao
 * @company
 * @create 2020-01-17 15:18
 */
@Data
public class OverflowList {

    /**
     * 编号
     */
    private Integer id;
    /**
     * 商品报溢单号
     */
    private String overflowNumber;
    /**
     * 商品报溢日期
     */
    private Date overflowDate;
    /**
     * 起始日期 搜索用到
     */
    private Date bOverflowDate;
    /**
     * 结束日期 搜索用到
     */
    private Date eOverflowDate;
    /**
     * 操作员
     */
    private User user;
    /**
     * 备注
     */
    private String remarks;
}
