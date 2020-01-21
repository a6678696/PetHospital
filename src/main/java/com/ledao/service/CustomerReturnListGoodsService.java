package com.ledao.service;

import com.ledao.entity.CustomerReturnListGoods;

import java.util.List;
import java.util.Map;

/**
 * 客户退货单商品Service接口
 *
 * @author LeDao
 * @company
 * @create 2020-01-17 19:16
 */
public interface CustomerReturnListGoodsService {

    /**
     * 根据客户退货单id查询所有客户退货单商品
     *
     * @param customerReturnListId
     * @return
     */
    List<CustomerReturnListGoods> listByCustomerReturnListId(Integer customerReturnListId);

    /**
     * 根据客户退货单id删除所有客户退货单商品
     *
     * @param customerReturnListId
     * @return
     */
    Integer deleteByCustomerReturnListId(Integer customerReturnListId);

    /**
     * 统计某个商品的退货总数
     *
     * @param goodsId
     * @return
     */
    Long getTotalByGoodsId(Integer goodsId);

    /**
     * 查询退货商品信息
     *
     * @param map
     * @return
     */
    List<CustomerReturnListGoods> list(Map<String, Object> map);

    /**
     * 添加客户退货单商品
     *
     * @param customerReturnListGoods
     * @return
     */
    Integer add(CustomerReturnListGoods customerReturnListGoods);
}
