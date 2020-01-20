package com.ledao.mapper;

import com.ledao.entity.SaleListGoods;

import java.util.List;
import java.util.Map;

/**
 * 销售单商品mapper接口
 *
 * @author LeDao
 * @company
 * @create 2020-01-18 16:43
 */
public interface SaleListGoodsMapper {

    /**
     * 根据销售单id查询所有销售单商品
     *
     * @param saleListId
     * @return
     */
    List<SaleListGoods> listBySaleListId(Integer saleListId);

    /**
     * 根据销售单id删除所有销售单商品
     *
     * @param saleListId
     * @return
     */
    Integer deleteBySaleListId(Integer saleListId);

    /**
     * 统计某个商品的销售总数
     *
     * @param goodsId
     * @return
     */
    Long getTotalByGoodsId(Integer goodsId);

    /**
     * 根据条件查询销售单商品
     *
     * @param map
     * @return
     */
    List<SaleListGoods> list(Map<String, Object> map);
}
