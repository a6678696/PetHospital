package com.ledao.entity;

import com.ledao.util.DateUtil;
import lombok.Data;
import lombok.SneakyThrows;

import java.beans.Transient;
import java.util.Date;
import java.util.List;

/**
 * 退货单实体
 *
 * @author LeDao
 * @company
 * @create 2020-01-17 15:31
 */
@Data
public class ReturnList {

    /**
     * 编号
     */
    private Integer id;
    /**
     * 退货单号
     */
    private String returnNumber;
    /**
     * 供应商
     */
    private Supplier supplier;
    /**
     * 退货日期
     */
    private Date returnDate;
    /**
     * 起始日期 搜索用到
     */
    private Date bReturnDate;
    /**
     * 结束日期 搜索用到
     */
    private Date eReturnDate;
    /**
     * 应付金额
     */
    private float amountPayable;
    /**
     * 实付金额
     */
    private float amountPaid;
    /**
     * 是否收到退货款 1 已收 2 未收
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
     * 退货单商品集合
     */
    public List<ReturnListGoods> returnListGoodsList=null;

    @SneakyThrows
    @Override
    public String toString() {
        return "--{" +
                "编号=" + id +
                ", 退货单号='" + returnNumber + '\'' +
                ", 供应商=" + supplier.getName() +
                ", 退货日期=" + DateUtil.dateFormat(returnDate) +
                ", 操作员=" + user.getUserName() +
                '}';
    }
}
