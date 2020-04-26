package com.ledao.service;

import com.ledao.entity.TackleOutLog;

import java.util.List;
import java.util.Map;

/**
 * 医院用品出库记录Service接口
 *
 * @author LeDao
 * @company
 * @create 2020-04-26 23:29
 */
public interface TackleOutLogService {

    /**
     * 根据条件分页查询医院用品出库记录
     *
     * @param map
     * @return
     */
    List<TackleOutLog> list(Map<String, Object> map);

    /**
     * 获取记录数
     *
     * @param map
     * @return
     */
    Long getCount(Map<String, Object> map);

    /**
     * 添加医院用品出库记录
     *
     * @param tackleOutLog
     * @return
     */
    Integer add(TackleOutLog tackleOutLog);

    /**
     * 修改医院用品出库记录
     *
     * @param tackleOutLog
     * @return
     */
    Integer update(TackleOutLog tackleOutLog);

    /**
     * 根据id删除医院用品出库记录
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
    TackleOutLog findById(Integer id);
}
