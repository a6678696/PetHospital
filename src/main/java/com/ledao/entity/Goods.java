package com.ledao.entity;

import lombok.Data;

/**
 * @author LeDao
 * @company
 * @create 2020-01-17 15:11
 */
@Data
public class Goods {

    /**
     * 编号
     */
    private Integer id;
    /**
     * 商品编码
     */
    private String code;
    /**
     * 商品名称
     */
    private String name;
    /**
     * 图片名
     */
    private String imageName;
    /**
     * 商品型号
     */
    private String model;
    /**
     * 商品类别
     */
    private GoodsType type;
    /**
     * 商品单位
     */
    private String unit;
    /**
     * 上次采购价格
     */
    private float lastPurchasingPrice;
    /**
     * 采购价格  成本价  假如价格变动 算平均值
     */
    private float purchasingPrice;
    /**
     * 出售价格
     */
    private float sellingPrice;
    /**
     * 库存数量
     */
    private int inventoryQuantity;
    /**
     * 库存下限
     */
    private int minNum;
    /**
     * 0 初始化状态 1 期初库存入仓库  2  有进货或者销售单据
     */
    private int state;
    /**
     * 生产厂商
     */
    private String producer;
    /**
     * 备注
     */
    private String remarks;
    /**
     * 是否热卖 0否 1是
     */
    private Integer hot;
    /**
     * 是否特价 0否 1是
     */
    private Integer specialPrice;
    /**
     * 详情
     */
    private String details;
    /**
     * 查询用到 根据商品编码或者商品名称查询
     */
    private String codeOrName;
    /**
     * 销售总数
     */
    private Long saleTotal;

    @Override
    public String toString() {
        return "--{" +
                "id=" + id +
                ", 编号='" + code + '\'' +
                ", 商品名称='" + name + '\'' +
                ", 上次采购价格=" + lastPurchasingPrice +
                ", 采购价格=" + purchasingPrice +
                ", 出售价格=" + sellingPrice +
                '}';
    }
}
