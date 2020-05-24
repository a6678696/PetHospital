package com.ledao.entity;

import lombok.Data;

import java.util.Date;

/**
 * 客户订单支付记录实体
 *
 * @author LeDao
 * @company
 * @create 2020-05-22 14:15
 */
@Data
public class SaleListPaymentInformation {

    /**
     * 编号
     */
    private Integer id;
    /**
     * 订单编号
     */
    private String saleNumber;
    /**
     * 支付方式 1.支付宝支付 2.微信支付
     */
    private Integer type;
    /**
     * 支付金额
     */
    private float amount;
    /**
     * 客户id
     */
    private Integer customerId;
    /**
     * 客户实体
     */
    private Customer customer;
    /**
     * 支付时间
     */
    private Date payDate;
    /**
     * 订单备注
     */
    private String remark;
    /**
     *起始日期 搜索用到
     */
    private Date bSaleDate;
    /**
     *结束日期 搜索用到
     */
    private Date eSaleDate;
}
