package com.ledao.entity;

import java.util.Date;

/**
 * 客户订单支付记录实体
 *
 * @author LeDao
 * @company
 * @create 2020-05-22 14:15
 */
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

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getSaleNumber() {
        return saleNumber;
    }

    public void setSaleNumber(String saleNumber) {
        this.saleNumber = saleNumber;
    }

    public Integer getType() {
        return type;
    }

    public void setType(Integer type) {
        this.type = type;
    }

    public float getAmount() {
        return amount;
    }

    public void setAmount(float amount) {
        this.amount = amount;
    }

    public Integer getCustomerId() {
        return customerId;
    }

    public void setCustomerId(Integer customerId) {
        this.customerId = customerId;
    }

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    public Date getPayDate() {
        return payDate;
    }

    public void setPayDate(Date payDate) {
        this.payDate = payDate;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }

    public Date getbSaleDate() {
        return bSaleDate;
    }

    public void setbSaleDate(Date bSaleDate) {
        this.bSaleDate = bSaleDate;
    }

    public Date geteSaleDate() {
        return eSaleDate;
    }

    public void seteSaleDate(Date eSaleDate) {
        this.eSaleDate = eSaleDate;
    }

    @Override
    public String toString() {
        return "SaleListPaymentInformation{" +
                "id=" + id +
                ", saleNumber='" + saleNumber + '\'' +
                ", type=" + type +
                ", amount=" + amount +
                ", customerId=" + customerId +
                ", customer=" + customer +
                ", payDate=" + payDate +
                ", remark='" + remark + '\'' +
                ", bSaleDate=" + bSaleDate +
                ", eSaleDate=" + eSaleDate +
                '}';
    }
}
