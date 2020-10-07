package com.ledao.entity;

import java.io.Serializable;

/**
 * 购物车的某一个商品
 *
 * @author LeDao
 * @company
 * @create 2020-01-31 13:34
 */
public class ShoppingCartItem implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * 编号
     */
    private Integer id;
    /**
     * 商品
     */
    private Goods goods;
    /**
     * 商品数量
     */
    private Integer count;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Goods getGoods() {
        return goods;
    }

    public void setGoods(Goods goods) {
        this.goods = goods;
    }

    public Integer getCount() {
        return count;
    }

    public void setCount(Integer count) {
        this.count = count;
    }

    @Override
    public String toString() {
        return "ShoppingCartItem{" +
                "id=" + id +
                ", goods=" + goods +
                ", count=" + count +
                '}';
    }
}
