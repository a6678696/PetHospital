package com.ledao.entity;

import lombok.Data;

import java.beans.Transient;
import java.util.Date;
import java.util.List;

/**
 * 销售单实体
 *
 * @author LeDao
 * @company
 * @create 2020-01-17 15:38
 */
@Data
public class SaleList {

    /**
     * 编号
     */
    private Integer id;
    /**
     *销售单号
     */
    private String saleNumber;
    /**
     *客户
     */
    private Customer customer;
    /**
     *销售日期
     */
    private Date saleDate;
    /**
     *起始日期 搜索用到
     */
    private Date bSaleDate;
    /**
     *结束日期 搜索用到
     */
    private Date eSaleDate;
    /**
     *应付金额
     */
    private float amountPayable;
    /**
     *实付金额
     */
    private float amountPaid;
    /**
     *交易状态 1 已付 2 未付
     */
    private Integer state;
    /**
     *操作员
     */
    private User user;
    /**
     *备注
     */
    private String remarks;
    /**
     *销售单商品集合
     */
    private List<SaleListGoods> saleListGoodsList=null;
}
