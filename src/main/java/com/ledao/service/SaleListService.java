package com.ledao.service;

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
    List<Object> countSaleByDay(String begin, String end);

    /**
     * 按月统计某个日期范围内的销售信息
     *
     * @param begin
     * @param end
     * @return
     */
    List<Object> countSaleByMonth(String begin, String end);

    /**
     * 根据id查询实体
     *
     * @param id
     * @return
     */
    SaleList findById(Integer id);

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
     * 根据id删除销售单信息
     *
     * @param id
     * @return
     */
    Integer delete(Integer id);
}
