package com.ledao.entity;

import lombok.Data;

import java.util.Date;

/**
 * 客户商品评论实体
 *
 * @author LeDao
 * @company
 * @create 2020-05-27 21:00
 */
@Data
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
}
