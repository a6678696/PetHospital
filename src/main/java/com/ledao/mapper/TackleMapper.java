package com.ledao.mapper;

import com.ledao.entity.Tackle;

import java.util.List;
import java.util.Map;

/**
 * 医院用品Mapper接口
 *
 * @author LeDao
 * @company
 * @create 2020-04-08 10:19
 */
public interface TackleMapper {

    /**
     * 根据条件分页查询医院用品信息
     *
     * @param map
     * @return
     */
    List<Tackle> list(Map<String, Object> map);

    /**
     * 获取记录数
     *
     * @param map
     * @return
     */
    Long getCount(Map<String, Object> map);

    /**
     * 添加医院用品信息
     *
     * @param tackle
     * @return
     */
    Integer add(Tackle tackle);

    /**
     * 修改医院用品信息
     *
     * @param tackle
     * @return
     */
    Integer update(Tackle tackle);

    /**
     * 根据id删除医院用品
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
    Tackle findById(Integer id);

    /**
     * 根据医院用品名称查找实体
     *
     * @param name
     * @return
     */
    List<Tackle> findByName(String name);
}
