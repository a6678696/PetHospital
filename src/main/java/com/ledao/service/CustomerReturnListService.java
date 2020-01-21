package com.ledao.service;

import com.ledao.entity.CustomerReturnList;

import java.util.List;
import java.util.Map;

/**
 * 客户退货单Service接口
 *
 * @author LeDao
 * @company
 * @create 2020-01-18 00:16
 */
public interface CustomerReturnListService {

    /**
     * 获取当天最大客户退货单号
     *
     * @return
     */
    String getTodayMaxCustomerReturnNumber();

    /**
     * 根据id查询实体
     *
     * @param id
     * @return
     */
    CustomerReturnList findById(Integer id);

    /**
     * 根据客户退货单号查询实体
     *
     * @param customerReturnNumber
     * @return
     */
    CustomerReturnList findByCustomerReturnNumber(String customerReturnNumber);

    /**
     * 添加客户退货单
     *
     * @param customerReturnList
     * @return
     */
    Integer add(CustomerReturnList customerReturnList);

    /**
     * 修改客户退货单
     *
     * @param customerReturnList
     * @return
     */
    Integer update(CustomerReturnList customerReturnList);

    /**
     * 根据条件查询客户退货单信息
     *
     * @param map
     * @return
     */
    List<CustomerReturnList> list(Map<String, Object> map);

    /**
     * 根据id删除客户退货单信息 包括客户退货单里的所有商品
     *
     * @param id
     * @return
     */
    Integer delete(Integer id);
}
