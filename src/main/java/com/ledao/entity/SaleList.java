package com.ledao.entity;

import com.ledao.util.DateUtil;
import lombok.Data;
import lombok.SneakyThrows;

import java.util.Date;
import java.util.List;

/**
 * 销售单实体
 *
 * @author LeDao
 * @company
 * @create 2020-01-17 15:38
 */
@Data
public class SaleList {

    /**
     * 编号
     */
    private Integer id;
    /**
     *销售单号
     */
    private String saleNumber;
    /**
     *客户
     */
    private Customer customer;
    /**
     *销售日期
     */
    private Date saleDate;
    /**
     *起始日期 搜索用到
     */
    private Date bSaleDate;
    /**
     *结束日期 搜索用到
     */
    private Date eSaleDate;
    /**
     *应付金额
     */
    private float amountPayable;
    /**
     *实付金额
     */
    private float amountPaid;
    /**
     *交易状态 1 已收 2 未收
     */
    private Integer state;
    /**
     *操作员
     */
    private User user;
    /**
     *备注
     */
    private String remarks;
    /**
     *销售单商品集合
     */
    private List<SaleListGoods> saleListGoodsList=null;

    @SneakyThrows
    @Override
    public String toString() {
        return "--{" +
                "编号=" + id +
                ", 销售单号='" + saleNumber + '\'' +
                ", 客户=" + customer.getName() +
                ", 销售日期=" + DateUtil.dateFormat(saleDate) +
                ", 实付金额=" + amountPaid +
                '}';
    }
}
