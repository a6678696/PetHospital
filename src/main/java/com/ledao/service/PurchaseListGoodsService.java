package com.ledao.service;

import com.ledao.entity.PurchaseListGoods;

import java.util.List;
import java.util.Map;

/**
 * 进货单商品Service接口
 *
 * @author LeDao
 * @company
 * @create 2020-01-18 14:39
 */
public interface PurchaseListGoodsService {

    /**
     * 根据进货单id查询所有进货单商品
     *
     * @param purchaseListId
     * @return
     */
    List<PurchaseListGoods> listByPurchaseListId(Integer purchaseListId);

    /**
     * 根据进货单id删除所有进货单商品
     *
     * @param purchaseListId
     * @return
     */
    Integer deleteByPurchaseListId(Integer purchaseListId);

    /**
     * 根据条件查询进货单商品
     *
     * @param map
     * @return
     */
    List<PurchaseListGoods> list(Map<String, Object> map);

    /**
     * 条件进货单商品
     *
     * @param purchaseListGoods
     * @return
     */
    Integer add(PurchaseListGoods purchaseListGoods);
}
