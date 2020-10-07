package com.ledao.entity;

import java.util.Date;

/**
 * 商品报损单实体
 *
 * @author LeDao
 * @company
 * @create 2020-01-17 15:07
 */
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

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getDamageNumber() {
        return damageNumber;
    }

    public void setDamageNumber(String damageNumber) {
        this.damageNumber = damageNumber;
    }

    public Date getDamageDate() {
        return damageDate;
    }

    public void setDamageDate(Date damageDate) {
        this.damageDate = damageDate;
    }

    public Date getbDamageDate() {
        return bDamageDate;
    }

    public void setbDamageDate(Date bDamageDate) {
        this.bDamageDate = bDamageDate;
    }

    public Date geteDamageDate() {
        return eDamageDate;
    }

    public void seteDamageDate(Date eDamageDate) {
        this.eDamageDate = eDamageDate;
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
        return "DamageList{" +
                "id=" + id +
                ", damageNumber='" + damageNumber + '\'' +
                ", damageDate=" + damageDate +
                ", bDamageDate=" + bDamageDate +
                ", eDamageDate=" + eDamageDate +
                ", user=" + user +
                ", remarks='" + remarks + '\'' +
                '}';
    }
}
