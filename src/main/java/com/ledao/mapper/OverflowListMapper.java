package com.ledao.mapper;

import com.ledao.entity.OverflowList;

import java.util.List;
import java.util.Map;

/**
 * 商品报溢单mapper接口
 *
 * @author LeDao
 * @company
 * @create 2020-01-18 12:29
 */
public interface OverflowListMapper {

    /**
     * 获取当天最大商品报溢单号
     *
     * @return
     */
    String getTodayMaxOverflowNumber();

    /**
     * 根据id查询实体
     *
     * @param id
     * @return
     */
    OverflowList findById(Integer id);

    /**
     * 根据报溢单号查询实体
     *
     * @param overflowNumber
     * @return
     */
    OverflowList findByOverflowNumber(String overflowNumber);

    /**
     * 添加商品报溢单
     *
     * @param overflowList
     * @return
     */
    Integer add(OverflowList overflowList);

    /**
     * 修改商品报溢单
     *
     * @param overflowList
     * @return
     */
    Integer update(OverflowList overflowList);

    /**
     * 根据条件查询商品报溢单信息
     *
     * @param map
     * @return
     */
    List<OverflowList> list(Map<String, Object> map);
}
