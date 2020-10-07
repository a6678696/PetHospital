package com.ledao.entity;

import com.ledao.util.DateUtil;

import java.util.Date;
import java.util.List;

/**
 * 销售单实体
 *
 * @author LeDao
 * @company
 * @create 2020-01-17 15:38
 */
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
     * 客户id
     */
    private Integer customerId;
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
     *交易状态 1 已支付 2 未支付 3已发货 4派送中 5客户已收货 6订单已取消
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

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    public Integer getCustomerId() {
        return customerId;
    }

    public void setCustomerId(Integer customerId) {
        this.customerId = customerId;
    }

    public Date getSaleDate() {
        return saleDate;
    }

    public void setSaleDate(Date saleDate) {
        this.saleDate = saleDate;
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

    public float getAmountPayable() {
        return amountPayable;
    }

    public void setAmountPayable(float amountPayable) {
        this.amountPayable = amountPayable;
    }

    public float getAmountPaid() {
        return amountPaid;
    }

    public void setAmountPaid(float amountPaid) {
        this.amountPaid = amountPaid;
    }

    public Integer getState() {
        return state;
    }

    public void setState(Integer state) {
        this.state = state;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public String getRemarks() {
        return remarks;
    }

    public void setRemarks(String remarks) {
        this.remarks = remarks;
    }

    public List<SaleListGoods> getSaleListGoodsList() {
        return saleListGoodsList;
    }

    public void setSaleListGoodsList(List<SaleListGoods> saleListGoodsList) {
        this.saleListGoodsList = saleListGoodsList;
    }

    @Override
    public String toString() {
        return "SaleList{" +
                "id=" + id +
                ", saleNumber='" + saleNumber + '\'' +
                ", customer=" + customer +
                ", customerId=" + customerId +
                ", saleDate=" + saleDate +
                ", bSaleDate=" + bSaleDate +
                ", eSaleDate=" + eSaleDate +
                ", amountPayable=" + amountPayable +
                ", amountPaid=" + amountPaid +
                ", state=" + state +
                ", user=" + user +
                ", remarks='" + remarks + '\'' +
                ", saleListGoodsList=" + saleListGoodsList +
                '}';
    }
}
