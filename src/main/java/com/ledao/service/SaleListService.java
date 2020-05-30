package com.ledao.service;

import com.ledao.entity.SaleCount;
import com.ledao.entity.SaleList;

import java.util.List;
import java.util.Map;

/**
 * 销售单Service接口
 *
 * @author LeDao
 * @company
 * @create 2020-01-18 16:08
 */
public interface SaleListService {

    /**
     * 获取当天最大销售单号
     *
     * @return
     */
    String getTodayMaxSaleNumber();

    /**
     * 按天统计某个日期范围内的销售信息
     *
     * @param begin
     * @param end
     * @return
     */
    List<SaleCount> countSaleByDay(String begin, String end);

    /**
     * 按月统计某个日期范围内的销售信息
     *
     * @param begin
     * @param end
     * @return
     */
    List<SaleCount> countSaleByMonth(String begin, String end);

    /**
     * 根据id查询实体
     *
     * @param id
     * @return
     */
    SaleList findById(Integer id);

    /**
     * 根据销售单号查询销售单
     *
     * @param saleNumber
     * @return
     */
    SaleList findBySaleNumber(String saleNumber);

    /**
     * 添加销售单
     *
     * @param saleList
     * @return
     */
    Integer add(SaleList saleList);

    /**
     * 修改销售单
     *
     * @param saleList
     * @return
     */
    Integer update(SaleList saleList);

    /**
     * 根据条件查询销售单信息
     *
     * @param map
     * @return
     */
    List<SaleList> list(Map<String, Object> map);

    /**
     * 查询记录数
     *
     * @param map
     * @return
     */
    Long getCount(Map<String, Object> map);

    /**
     * 根据id删除销售单信息
     *
     * @param id
     * @return
     */
    Integer delete(Integer id);

    /**
     * 查询客户最新添加的一个订单,用来保存订单商品
     *
     * @param customerId
     * @return
     */
    SaleList findCurrentOneOrderByCustomerId(Integer customerId);

    /**
     * 取消客户提交的超过一天未支付的订单
     */
    void cancelOrderOverOneDay();

    /**
     * 超过14天的订单自动确认收货
     */
    void automaticReceiptConfirmation();
}
