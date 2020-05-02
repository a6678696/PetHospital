package com.ledao.mapper;

import com.ledao.entity.Information;

import java.util.List;
import java.util.Map;

/**
 * 客户消息Mapper接口
 *
 * @author LeDao
 * @company
 * @create 2020-05-01 22:02
 */
public interface InformationMapper {

    /**
     * 分页分条件查询客户消息
     *
     * @param map
     * @return
     */
    List<Information> list(Map<String, Object> map);

    /**
     * 获取记录数
     *
     * @param map
     * @return
     */
    Long getCount(Map<String, Object> map);

    /**
     * 添加客户消息
     *
     * @param information
     * @return
     */
    Integer add(Information information);

    /**
     * 修改客户消息
     *
     * @param information
     * @return
     */
    Integer update(Information information);

    /**
     * 根据id删除客户信息
     *
     * @param id
     * @return
     */
    Integer delete(Integer id);

    /**
     * 根据id查找实体
     *
     * @param id
     * @return
     */
    Information findById(Integer id);
}
