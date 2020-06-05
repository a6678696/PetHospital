package com.ledao.entity;

import lombok.Data;

import java.util.Date;

/**
 * 客户退货申请实体
 *
 * @author LeDao
 * @company
 * @create 2020-06-05 21:34
 */
@Data
public class ReturnApply {

    /**
     * 编号
     */
    private Integer id;
    /**
     * 所属订单编号
     */
    private Integer saleListId;
    /**
     * 所属订单号
     */
    private Integer saleListNumber;
    /**
     * 退货商品的所属订单商品编号
     */
    private Integer saleListGoodsId;
    /**
     * 退货数量
     */
    private Integer num;
    /**
     * 申请退货时间
     */
    private Date applyDate;
    /**
     * 退货理由
     */
    private String reason;
    /**
     *起始日期 搜索用到
     */
    private Date bSaleDate;
    /**
     *结束日期 搜索用到
     */
    private Date eSaleDate;
}
