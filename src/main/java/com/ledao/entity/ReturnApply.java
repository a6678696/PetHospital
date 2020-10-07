package com.ledao.entity;

import java.util.Date;

/**
 * 客户退货申请实体
 *
 * @author LeDao
 * @company
 * @create 2020-06-05 21:34
 */
public class ReturnApply {

    /**
     * 编号
     */
    private Integer id;
    /**
     * 客户id
     */
    private Integer customerId;
    /**
     * 客户实体
     */
    private Customer customer;
    /**
     * 所属订单编号
     */
    private Integer saleListId;
    /**
     * 所属订单号
     */
    private String saleListNumber;
    /**
     * 退货商品的所属订单商品编号
     */
    private Integer saleListGoodsId;
    /**
     * 退货商品的所属订单商品
     */
    private SaleListGoods saleListGoods;
    /**
     * 退货数量
     */
    private Integer num;
    /**
     * 申请退货时间
     */
    private Date applyDate;
    /**
     * 退货理由
     */
    private String reason;
    /**
     * 当前状态 0.审核中 1.同意退货 2.不同意退货
     */
    private Integer status;
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

    public Integer getSaleListId() {
        return saleListId;
    }

    public void setSaleListId(Integer saleListId) {
        this.saleListId = saleListId;
    }

    public String getSaleListNumber() {
        return saleListNumber;
    }

    public void setSaleListNumber(String saleListNumber) {
        this.saleListNumber = saleListNumber;
    }

    public Integer getSaleListGoodsId() {
        return saleListGoodsId;
    }

    public void setSaleListGoodsId(Integer saleListGoodsId) {
        this.saleListGoodsId = saleListGoodsId;
    }

    public SaleListGoods getSaleListGoods() {
        return saleListGoods;
    }

    public void setSaleListGoods(SaleListGoods saleListGoods) {
        this.saleListGoods = saleListGoods;
    }

    public Integer getNum() {
        return num;
    }

    public void setNum(Integer num) {
        this.num = num;
    }

    public Date getApplyDate() {
        return applyDate;
    }

    public void setApplyDate(Date applyDate) {
        this.applyDate = applyDate;
    }

    public String getReason() {
        return reason;
    }

    public void setReason(String reason) {
        this.reason = reason;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
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
        return "ReturnApply{" +
                "id=" + id +
                ", customerId=" + customerId +
                ", customer=" + customer +
                ", saleListId=" + saleListId +
                ", saleListNumber='" + saleListNumber + '\'' +
                ", saleListGoodsId=" + saleListGoodsId +
                ", saleListGoods=" + saleListGoods +
                ", num=" + num +
                ", applyDate=" + applyDate +
                ", reason='" + reason + '\'' +
                ", status=" + status +
                ", bSaleDate=" + bSaleDate +
                ", eSaleDate=" + eSaleDate +
                '}';
    }
}
