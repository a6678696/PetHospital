package com.ledao.entity;

import lombok.Data;
/**
 * 客户退货单商品实体
 *
 * @author LeDao
 * @company
 * @create 2020-01-17 15:04
 */
@Data
public class CustomerReturnListGoods {

    /**
     * 编号
     */
    private Integer id;
    /**
     * 客户退货单
     */
    private CustomerReturnList customerReturnList;
    /**
     * 商品编码
     */
    private String code;
    /**
     * 商品名称
     */
    private String name;
    /**
     * 商品型号
     */
    private String model;
    /**
     * 商品类别
     */
    private GoodsType type;
    /**
     * 类别id
     */
    private Integer typeId;
    /**
     * 商品id
     */
    private Integer goodsId;
    /**
     * 商品单位
     */
    private String unit;
    /**
     * 单价
     */
    private float price;
    /**
     * 数量
     */
    private int num;
    /**
     * 总金额
     */
    private float total;
    /**
     * 查询用到 根据商品编码或者商品名称查询
     */
    private String codeOrName;
}
