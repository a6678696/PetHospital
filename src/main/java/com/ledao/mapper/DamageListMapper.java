package com.ledao.mapper;

import com.ledao.entity.DamageList;

import java.util.List;
import java.util.Map;

/**
 * 商品报损单mapper接口
 *
 * @author LeDao
 * @company
 * @create 2020-01-18 11:20
 */
public interface DamageListMapper {

    /**
     * 获取当天最大商品报损单号
     *
     * @return
     */
    String getTodayMaxDamageNumber();

    /**
     * 根据id查询实体
     *
     * @param id
     * @return
     */
    DamageList findById(Integer id);

    /**
     * 根据报损单号查询实体
     *
     * @param damageNumber
     * @return
     */
    DamageList findByDamageNumber(String damageNumber);

    /**
     * 添加商品报损单
     *
     * @param damageList
     * @return
     */
    Integer add(DamageList damageList);

    /**
     * 修改商品报损单
     *
     * @param damageList
     * @return
     */
    Integer update(DamageList damageList);

    /**
     * 根据条件查询商品报损单信息
     *
     * @param map
     * @return
     */
    List<DamageList> list(Map<String, Object> map);
}
