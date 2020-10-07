package com.ledao.entity;

import java.util.Date;

/**
 * 我的收藏(收藏商品)
 *
 * @author LeDao
 * @company
 * @create 2020-02-03 12:30
 */
public class Favorite {

    /**
     * 编号
     */
    private Integer id;
    /**
     * 收藏的客户
     */
    private Customer customer;
    /**
     * 收藏的商品
     */
    private Goods goods;
    /**
     * 收藏的时间
     */
    private Date addDate;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    public Goods getGoods() {
        return goods;
    }

    public void setGoods(Goods goods) {
        this.goods = goods;
    }

    public Date getAddDate() {
        return addDate;
    }

    public void setAddDate(Date addDate) {
        this.addDate = addDate;
    }

    @Override
    public String toString() {
        return "Favorite{" +
                "id=" + id +
                ", customer=" + customer +
                ", goods=" + goods +
                ", addDate=" + addDate +
                '}';
    }
}
