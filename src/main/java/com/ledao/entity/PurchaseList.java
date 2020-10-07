package com.ledao.entity;

import com.ledao.util.DateUtil;

import java.util.Date;
import java.util.List;

/**
 * 进货单实体
 *
 * @author LeDao
 * @company
 * @create 2020-01-17 15:23
 */
public class PurchaseList {

    /**
     * 编号
     */
    private Integer id;
    /**
     * 进货单号
     */
    private String purchaseNumber;
    /**
     * 供应商
     */
    private Supplier supplier;
    /**
     * 进货日期
     */
    private Date purchaseDate;
    /**
     * 起始日期 搜索用到
     */
    private Date bPurchaseDate;
    /**
     * 结束日期 搜索用到
     */
    private Date ePurchaseDate;
    /**
     * 应付金额
     */
    private float amountPayable;
    /**
     * 实付金额
     */
    private float amountPaid;
    /**
     * 交易状态 1 已付 2 未付
     */
    private Integer state;
    /**
     * 操作员
     */
    private User user;
    /**
     * 备注
     */
    private String remarks;
    /**
     * 采购单商品集合
     */
    private List<PurchaseListGoods> purchaseListGoodsList=null;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getPurchaseNumber() {
        return purchaseNumber;
    }

    public void setPurchaseNumber(String purchaseNumber) {
        this.purchaseNumber = purchaseNumber;
    }

    public Supplier getSupplier() {
        return supplier;
    }

    public void setSupplier(Supplier supplier) {
        this.supplier = supplier;
    }

    public Date getPurchaseDate() {
        return purchaseDate;
    }

    public void setPurchaseDate(Date purchaseDate) {
        this.purchaseDate = purchaseDate;
    }

    public Date getbPurchaseDate() {
        return bPurchaseDate;
    }

    public void setbPurchaseDate(Date bPurchaseDate) {
        this.bPurchaseDate = bPurchaseDate;
    }

    public Date getePurchaseDate() {
        return ePurchaseDate;
    }

    public void setePurchaseDate(Date ePurchaseDate) {
        this.ePurchaseDate = ePurchaseDate;
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

    public List<PurchaseListGoods> getPurchaseListGoodsList() {
        return purchaseListGoodsList;
    }

    public void setPurchaseListGoodsList(List<PurchaseListGoods> purchaseListGoodsList) {
        this.purchaseListGoodsList = purchaseListGoodsList;
    }

    @Override
    public String toString() {
        return "PurchaseList{" +
                "id=" + id +
                ", purchaseNumber='" + purchaseNumber + '\'' +
                ", supplier=" + supplier +
                ", purchaseDate=" + purchaseDate +
                ", bPurchaseDate=" + bPurchaseDate +
                ", ePurchaseDate=" + ePurchaseDate +
                ", amountPayable=" + amountPayable +
                ", amountPaid=" + amountPaid +
                ", state=" + state +
                ", user=" + user +
                ", remarks='" + remarks + '\'' +
                ", purchaseListGoodsList=" + purchaseListGoodsList +
                '}';
    }
}
