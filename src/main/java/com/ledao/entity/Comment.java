package com.ledao.entity;

import java.util.Date;

/**
 * 客户商品评论实体
 *
 * @author LeDao
 * @company
 * @create 2020-05-27 21:00
 */
public class Comment {

    /**
     * 编号
     */
    private Integer id;
    /**
     * 评论内容
     */
    private String content;
    /**
     * 商品id
     */
    private Integer goodsId;
    /**
     * 商品实体
     */
    private Goods goods;
    /**
     * 客户订单商品id
     */
    private Integer saleListGoodsId;
    /**
     * 客户订单商品
     */
    private SaleListGoods saleListGoods;
    /**
     * 所属订单实体
     */
    private SaleList saleList;
    /**
     * 评论客户id
     */
    private Integer customerId;
    /**
     * 评价客户实体
     */
    private Customer customer;
    /**
     * 评论时间
     */
    private Date createDate;
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

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public Integer getGoodsId() {
        return goodsId;
    }

    public void setGoodsId(Integer goodsId) {
        this.goodsId = goodsId;
    }

    public Goods getGoods() {
        return goods;
    }

    public void setGoods(Goods goods) {
        this.goods = goods;
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

    public SaleList getSaleList() {
        return saleList;
    }

    public void setSaleList(SaleList saleList) {
        this.saleList = saleList;
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

    public Date getCreateDate() {
        return createDate;
    }

    public void setCreateDate(Date createDate) {
        this.createDate = createDate;
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
        return "Comment{" +
                "id=" + id +
                ", content='" + content + '\'' +
                ", goodsId=" + goodsId +
                ", goods=" + goods +
                ", saleListGoodsId=" + saleListGoodsId +
                ", saleListGoods=" + saleListGoods +
                ", saleList=" + saleList +
                ", customerId=" + customerId +
                ", customer=" + customer +
                ", createDate=" + createDate +
                ", bSaleDate=" + bSaleDate +
                ", eSaleDate=" + eSaleDate +
                '}';
    }
}
