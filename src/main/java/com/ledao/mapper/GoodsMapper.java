package com.ledao.mapper;

import com.ledao.entity.Goods;

import java.util.List;
import java.util.Map;

/**
 * 商品mapper接口
 *
 * @author LeDao
 * @company
 * @create 2020-01-17 22:04
 */
public interface GoodsMapper {

    /**
     * 查询某个类别下的所有商品
     *
     * @param typeId
     * @return
     */
    List<Goods> findByTypeId(Integer typeId);

    /**
     * 查询某个商品大类下的所有商品
     *
     * @param map
     * @return
     */
    List<Goods> listByBigTypeId(Map<String, Object> map);

    /**
     * 查询某个商品大类下的所有商品总记录数
     *
     * @param map
     * @return
     */
    Long getCountByBigTypeId(Map<String, Object> map);

    /**
     * 获取最大的商品编码
     *
     * @return
     */
    String getMaxGoodsCode();

    /**
     * 查询库存报警商品，实际库存小于库存下限的商品
     *
     * @return
     */
    List<Goods> listAlarm();

    /**
     * 根据条件分页查询商品信息
     *
     * @param map
     * @return
     */
    List<Goods> list(Map<String, Object> map);

    /**
     * 获取总记录数
     *
     * @param map
     * @return
     */
    Long getCount(Map<String, Object> map);

    /**
     * 根据条件分页查询商品库存信息
     *
     * @param map
     * @return
     */
    List<Goods> listInventory(Map<String, Object> map);

    /**
     * 获取商品库存信息记录数
     *
     * @param map
     * @return
     */
    Long getCountInventory(Map<String, Object> map);

    /**
     * 根据商品编码或商品名称条件分页查询没有库存的商品信息
     *
     * @param map
     * @return
     */
    List<Goods> listNoInventoryQuantityByCodeOrName(Map<String, Object> map);

    /**
     * 根据商品编码或商品名称条件分页查询没有库存的商品信息的总记录数
     *
     * @param map
     * @return
     */
    Long getCountNoInventoryQuantityByCodeOrName(Map<String, Object> map);

    /**
     * 根据商品编码或商品名称条件分页查询有库存的商品信息
     *
     * @param map
     * @return
     */
    List<Goods> listHasInventoryQuantityByCodeOrName(Map<String, Object> map);

    /**
     * 根据商品编码或商品名称条件分页查询有库存的商品信息的总记录数
     *
     * @param map
     * @return
     */
    Long getCountHasInventoryQuantityByCodeOrName(Map<String, Object> map);

    /**
     * 删除商品
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
    Goods findById(Integer id);

    /**
     * 添加商品
     *
     * @param goods
     * @return
     */
    Integer add(Goods goods);

    /**
     * 修改商品
     *
     * @param goods
     * @return
     */
    Integer update(Goods goods);

    /**
     * 查找发布超过3个月的商品
     *
     * @return
     */
    List<Goods> findOldGoods();
}
