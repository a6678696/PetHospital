package com.ledao.mapper;
;
import com.ledao.entity.DamageListGoods;

import java.util.List;

/**
 * 商品报损单商品mapper接口
 *
 * @author LeDao
 * @company
 * @create 2020-01-18 11:42
 */
public interface DamageListGoodsMapper {

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
