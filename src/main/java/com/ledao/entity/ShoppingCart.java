package com.ledao.entity;

import lombok.Data;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/**
 * 购物车实体
 *
 * @author LeDao
 * @company
 * @create 2020-01-31 13:33
 */
@Data
public class ShoppingCart implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * 操作购物车的用户
     */
    private Integer customerId;

    /**
     * 购物车内商品集合
     */
    private List<ShoppingCartItem> shoppingCartItems=new ArrayList<>();

    /**
     * 购物车内商品总金额
     */
    private Integer total;
}