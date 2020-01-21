package com.ledao.service;

import com.ledao.entity.DamageListGoods;

import java.util.List;

/**
 * 商品报损单商品Service接口
 *
 * @author LeDao
 * @company
 * @create 2020-01-18 11:43
 */
public interface DamageListGoodsService {

    /**
     * 根据商品报损单id查询所有商品报损单商品
     *
     * @param damageListId
     * @return
     */
    List<DamageListGoods> listByDamageListId(Integer damageListId);

    /**
     * 根据商品报损单id删除所有商品报损单商品
     *
     * @param damageListId
     * @return
     */
    Integer deleteByDamageListId(Integer damageListId);

    /**
     * 添加报损单商品
     *
     * @param damageListGoods
     * @return
     */
    Integer add(DamageListGoods damageListGoods);
}
