package com.ledao.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;

import java.beans.Transient;

/**
 * 销售单商品实体
 *
 * @author LeDao
 * @company
 * @create 2020-01-17 15:40
 */
@Data
public class SaleListGoods {

    /**
     *编号
     */
    private Integer id;
    /**
     *销售单
     */
    private SaleList saleList;
    /**
     * 商品的订单编号
     */
    private Integer saleListId;
    /**
     *商品编码
     */
    private String code;
    /**
     *商品名称
     */
    private String name;
    /**
     *商品型号
     */
    private String model;
    /**
     *商品类别
     */
    private GoodsType type;
    /**
     *类别id
     */
    private Integer typeId;
    /**
     *商品id
     */
    private Integer goodsId;
    /**
     * 商品实体
     */
    private Goods goods;
    /**
     *商品单位
     */
    private String unit;
    /**
     *单价
     */
    private float price;
    /**
     *数量
     */
    private int num;
    /**
     *总金额
     */
    private float total;
    /**
     *查询用到 根据商品编码或者商品名称查询
     */
    private String codeOrName;
    /**
     * 是否评价 0.未评价 1.已评价
     */
    private Integer status;
    /**
     * 是否可退货 0.不可以  1.可以
     */
    private Integer canReturn=0;
    /**
     * 可以退货的数量
     */
    private Integer canReturnNum;
    /**
     * 已退货数量
     */
    private Integer returnNum;
    /**
     * 上次填写退货信息时的数量
     */
    private Integer lastReturnNum;
}
