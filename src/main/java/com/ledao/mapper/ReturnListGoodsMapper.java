package com.ledao.mapper;

import com.ledao.entity.ReturnListGoods;

import java.util.List;
import java.util.Map;

/**
 * 退货单商品mapper接口
 *
 * @author LeDao
 * @company
 * @create 2020-01-18 15:06
 */
public interface ReturnListGoodsMapper {

    /**
     * 根据退货单id查询所有退货单商品
     *
     * @param returnListId
     * @return
     */
    List<ReturnListGoods> listByReturnListId(Integer returnListId);

    /**
     * 根据退货单id删除所有退货单商品
     *
     * @param returnListId
     * @return
     */
    Integer deleteByReturnListId(Integer returnListId);

    /**
     * 根据条件查询退货单商品
     *
     * @param map
     * @return
     */
    List<ReturnListGoods> list(Map<String, Object> map);
}
