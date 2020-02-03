package com.ledao.entity;

import lombok.Data;

import java.util.Date;

/**
 * 我的收藏(收藏商品)
 *
 * @author LeDao
 * @company
 * @create 2020-02-03 12:30
 */
@Data
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
}
