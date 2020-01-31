package com.ledao.entity;

import lombok.Data;

import java.io.Serializable;

/**
 * 购物车的某一个商品
 *
 * @author LeDao
 * @company
 * @create 2020-01-31 13:34
 */
@Data
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
}
