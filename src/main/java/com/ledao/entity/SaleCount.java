package com.ledao.entity;

import lombok.Data;

/**
 * 销售统计
 *
 * @author LeDao
 * @company
 * @create 2020-01-17 15:37
 */
@Data
public class SaleCount {

    /**
     * 成本总金额
     */
    private float amountCost;
    /**
     *销售总金额
     */
    private float amountSale;
    /**
     *销售利润
     */
    private float amountProfit;
    /**
     *日期
     */
    private String date;
}
