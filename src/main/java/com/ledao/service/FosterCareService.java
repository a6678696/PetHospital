package com.ledao.service;

import com.ledao.entity.FosterCare;

import java.util.List;
import java.util.Map;

/**
 * 寄养记录Service接口
 *
 * @author LeDao
 * @company
 * @create 2020-03-20 20:05
 */
public interface FosterCareService {

    /**
     * 分页分条件查询寄养记录
     *
     * @param map
     * @return
     */
    List<FosterCare> list(Map<String, Object> map);

    /**
     * 获取记录数
     *
     * @param map
     * @return
     */
    Long getCount(Map<String, Object> map);

    /**
     * 添加寄养记录
     *
     * @param fosterCare
     * @return
     */
    Integer add(FosterCare fosterCare);

    /**
     * 修改寄养记录
     *
     * @param fosterCare
     * @return
     */
    Integer update(FosterCare fosterCare);

    /**
     * 根据id删除寄养记录
     *
     * @param id
     * @return
     */
    Integer delete(Integer id);

    /**
     * 根据id查找寄养记录
     *
     * @param id
     * @return
     */
    FosterCare findById(Integer id);
}
