package com.ledao.service;

import com.ledao.entity.OverflowList;

import java.util.List;
import java.util.Map;

/**
 * @author LeDao
 * @company
 * @create 2020-01-18 12:32
 */
public interface OverflowListService {

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
