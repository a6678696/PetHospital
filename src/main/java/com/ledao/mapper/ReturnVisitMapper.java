package com.ledao.mapper;

import com.ledao.entity.ReturnVisit;

import java.util.List;
import java.util.Map;

/**
 * 客户回访记录Mapper接口
 *
 * @author LeDao
 * @company
 * @create 2020-03-18 23:45
 */
public interface ReturnVisitMapper {

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
     * 添加客户回访记录
     *
     * @param returnVisit
     * @return
     */
    Integer add(ReturnVisit returnVisit);

    /**
     * 修改客户回访记录
     *
     * @param returnVisit
     * @return
     */
    Integer update(ReturnVisit returnVisit);

    /**
     * 根据id删除客户回访记录
     *
     * @param id
     * @return
     */
    Integer delete(Integer id);

    /**
     * 根据id查询客户回访记录
     *
     * @param id
     * @return
     */
    ReturnVisit findById(Integer id);
}
