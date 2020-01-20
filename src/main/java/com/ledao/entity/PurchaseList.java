package com.ledao.entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;

import java.beans.Transient;
import java.util.Date;
import java.util.List;

/**
 * 进货单实体
 *
 * @author LeDao
 * @company
 * @create 2020-01-17 15:23
 */
@Data
public class PurchaseList {

    /**
     * 编号
     */
    private Integer id;
    /**
     * 进货单号
     */
    private String purchaseNumber;
    /**
     * 供应商
     */
    private Supplier supplier;
    /**
     * 进货日期
     */
    private Date purchaseDate;
    /**
     * 起始日期 搜索用到
     */
    private Date bPurchaseDate;
    /**
     * 结束日期 搜索用到
     */
    private Date ePurchaseDate;
    /**
     * 应付金额
     */
    private float amountPayable;
    /**
     * 实付金额
     */
    private float amountPaid;
    /**
     * 交易状态 1 已付 2 未付
     */
    private Integer state;
    /**
     * 操作员
     */
    private User user;
    /**
     * 备注
     */
    private String remarks;
    /**
     * 采购单商品集合
     */
    private List<PurchaseListGoods> purchaseListGoodsList=null;
}
