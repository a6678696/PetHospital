package com.ledao.mapper;

import com.ledao.entity.OverflowListGoods;

import java.util.List;

/**
 * 商品报溢单商品mapper接口
 *
 * @author LeDao
 * @company
 * @create 2020-01-18 12:21
 */
public interface OverflowListGoodsMapper {

    /**
     * 根据商品报溢单id查询所有商品报溢单商品
     *
     * @param overflowListId
     * @return
     */
    List<OverflowListGoods> listByOverflowListId(Integer overflowListId);

    /**
     * 根据商品报溢单id删除所有商品报溢单商品
     *
     * @param overflowListId
     * @return
     */
    Integer deleteByOverflowListId(Integer overflowListId);

    /**
     * 添加报溢单商品
     *
     * @param overflowListGoods
     * @return
     */
    Integer add(OverflowListGoods overflowListGoods);
}
