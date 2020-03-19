package com.ledao.service;

import com.ledao.entity.ReturnVisit;

import java.util.List;
import java.util.Map;

/**
 * 客户回访记录Service接口
 *
 * @author LeDao
 * @company
 * @create 2020-03-18 23:59
 */
public interface ReturnVisitService {

    /**
     * 根据条件查询客户回访记录
     *
     * @param map
     * @return
     */
    List<ReturnVisit> list(Map<String, Object> map);

    /**
     * 获取记录数
     *
     * @param map
     * @return
     */
    Long getCount(Map<String, Object> map);

    /**
     * 添加病历单
     *
     * @param returnVisit
     * @return
     */
    Integer add(ReturnVisit returnVisit);

    /**
     * 修改病历单
     *
     * @param returnVisit
     * @return
     */
    Integer update(ReturnVisit returnVisit);

    /**
     * 根据id删除病历单
     *
     * @param id
     * @return
     */
    Integer delete(Integer id);

    /**
     * 根据id查询病历单
     *
     * @param id
     * @return
     */
    ReturnVisit findById(Integer id);
}
