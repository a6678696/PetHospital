package com.ledao.mapper;

import com.ledao.entity.PurchaseList;

import java.util.List;
import java.util.Map;

/**
 * 进货单mapper接口
 *
 * @author LeDao
 * @company
 * @create 2020-01-18 12:54
 */
public interface PurchaseListMapper {

    /**
     * 获取当天最大进货单号
     *
     * @return
     */
    String getTodayMaxPurchaseNumber();

    /**
     * 根据id查询实体
     *
     * @param id
     * @return
     */
    PurchaseList findById(Integer id);

    /**
     * 根据订单号查询订单
     *
     * @param purchaseNumber
     * @return
     */
    PurchaseList findByPurchaseNumber(String purchaseNumber);

    /**
     * 根据条件查询进货单信息
     *
     * @param map
     * @return
     */
    List<PurchaseList> list(Map<String, Object> map);

    /**
     * 添加进货单
     *
     * @param purchaseList
     * @return
     */
    Integer add(PurchaseList purchaseList);

    /**
     * 修改进货单
     *
     * @param purchaseList
     * @return
     */
    Integer update(PurchaseList purchaseList);

    /**
     * 根据id删除进货单信息
     *
     * @param id
     * @return
     */
    Integer delete(Integer id);
}
