package com.ledao.mapper;

import com.ledao.entity.GoodsUnit;

import java.util.List;

/**
 * 商品单位mapper接口
 *
 * @author LeDao
 * @company
 * @create 2020-01-18 11:58
 */
public interface GoodsUnitMapper {

    /**
     * 查询所有商品单位信息
     *
     * @return
     */
    List<GoodsUnit> listAll();

    /**
     * 添加商品单位
     *
     * @param goodsUnit
     * @return
     */
    Integer add(GoodsUnit goodsUnit);

    /**
     * 修改商品单位
     *
     * @param goodsUnit
     * @return
     */
    Integer update(GoodsUnit goodsUnit);

    /**
     * 根据id删除商品单位
     *
     * @param id
     * @return
     */
    Integer delete(Integer id);

    /**
     * 根据id查询实体
     *
     * @param id
     * @return
     */
    GoodsUnit findById(Integer id);
}
