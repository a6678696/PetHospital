package com.ledao.entity;

import java.util.Date;

/**
 * 商品报溢单实体
 *
 * @author LeDao
 * @company
 * @create 2020-01-17 15:18
 */
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

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getOverflowNumber() {
        return overflowNumber;
    }

    public void setOverflowNumber(String overflowNumber) {
        this.overflowNumber = overflowNumber;
    }

    public Date getOverflowDate() {
        return overflowDate;
    }

    public void setOverflowDate(Date overflowDate) {
        this.overflowDate = overflowDate;
    }

    public Date getbOverflowDate() {
        return bOverflowDate;
    }

    public void setbOverflowDate(Date bOverflowDate) {
        this.bOverflowDate = bOverflowDate;
    }

    public Date geteOverflowDate() {
        return eOverflowDate;
    }

    public void seteOverflowDate(Date eOverflowDate) {
        this.eOverflowDate = eOverflowDate;
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

    @Override
    public String toString() {
        return "OverflowList{" +
                "id=" + id +
                ", overflowNumber='" + overflowNumber + '\'' +
                ", overflowDate=" + overflowDate +
                ", bOverflowDate=" + bOverflowDate +
                ", eOverflowDate=" + eOverflowDate +
                ", user=" + user +
                ", remarks='" + remarks + '\'' +
                '}';
    }
}
