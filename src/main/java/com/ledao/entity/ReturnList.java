package com.ledao.entity;

import java.util.Date;
import java.util.List;

/**
 * 退货单实体
 *
 * @author LeDao
 * @company
 * @create 2020-01-17 15:31
 */
public class ReturnList {

    /**
     * 编号
     */
    private Integer id;
    /**
     * 退货单号
     */
    private String returnNumber;
    /**
     * 供应商
     */
    private Supplier supplier;
    /**
     * 退货日期
     */
    private Date returnDate;
    /**
     * 起始日期 搜索用到
     */
    private Date bReturnDate;
    /**
     * 结束日期 搜索用到
     */
    private Date eReturnDate;
    /**
     * 应付金额
     */
    private float amountPayable;
    /**
     * 实付金额
     */
    private float amountPaid;
    /**
     * 是否收到退货款 1 已收 2 未收
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
     * 退货单商品集合
     */
    public List<ReturnListGoods> returnListGoodsList=null;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getReturnNumber() {
        return returnNumber;
    }

    public void setReturnNumber(String returnNumber) {
        this.returnNumber = returnNumber;
    }

    public Supplier getSupplier() {
        return supplier;
    }

    public void setSupplier(Supplier supplier) {
        this.supplier = supplier;
    }

    public Date getReturnDate() {
        return returnDate;
    }

    public void setReturnDate(Date returnDate) {
        this.returnDate = returnDate;
    }

    public Date getbReturnDate() {
        return bReturnDate;
    }

    public void setbReturnDate(Date bReturnDate) {
        this.bReturnDate = bReturnDate;
    }

    public Date geteReturnDate() {
        return eReturnDate;
    }

    public void seteReturnDate(Date eReturnDate) {
        this.eReturnDate = eReturnDate;
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

    public List<ReturnListGoods> getReturnListGoodsList() {
        return returnListGoodsList;
    }

    public void setReturnListGoodsList(List<ReturnListGoods> returnListGoodsList) {
        this.returnListGoodsList = returnListGoodsList;
    }

    @Override
    public String toString() {
        return "ReturnList{" +
                "id=" + id +
                ", returnNumber='" + returnNumber + '\'' +
                ", supplier=" + supplier +
                ", returnDate=" + returnDate +
                ", bReturnDate=" + bReturnDate +
                ", eReturnDate=" + eReturnDate +
                ", amountPayable=" + amountPayable +
                ", amountPaid=" + amountPaid +
                ", state=" + state +
                ", user=" + user +
                ", remarks='" + remarks + '\'' +
                ", returnListGoodsList=" + returnListGoodsList +
                '}';
    }
}
