package com.ledao.mapper;

import com.ledao.entity.SaleListPaymentInformation;

import java.util.List;
import java.util.Map;

/**
 * 客户订单支付记录Mapper接口
 *
 * @author LeDao
 * @company
 * @create 2020-05-22 14:28
 */
public interface SaleListPaymentInformationMapper {

    /**
     * 条件查询客户支付记录
     *
     * @param map
     * @return
     */
    List<SaleListPaymentInformation> list(Map<String, Object> map);

    /**
     * 获取记录数
     *
     * @param map
     * @return
     */
    Long getCount(Map<String, Object> map);

    /**
     * 添加客户支付记录
     *
     * @param saleListPaymentInformation
     * @return
     */
    Integer add(SaleListPaymentInformation saleListPaymentInformation);
}
