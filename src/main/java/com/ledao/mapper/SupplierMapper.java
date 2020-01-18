package com.ledao.mapper;

import com.ledao.entity.Supplier;

import java.util.List;
import java.util.Map;

/**
 * 供应商mapper接口
 *
 * @author LeDao
 * @company
 * @create 2020-01-18 13:06
 */
public interface SupplierMapper {

    /**
     * 根据名称模糊查询供应商信息
     *
     * @param name
     * @return
     */
    List<Supplier> findByName(String name);

    /**
     * 根据条件分页查询供应商信息
     *
     * @param map
     * @return
     */
    List<Supplier> list(Map<String, Object> map);

    /**
     * 获取总记录数
     *
     * @param map
     * @return
     */
    Long getCount(Map<String, Object> map);

    /**
     * 添加供应商信息
     *
     * @param supplier
     * @return
     */
    Integer add(Supplier supplier);

    /**
     * 修改供应商信息
     *
     * @param supplier
     * @return
     */
    Integer update(Supplier supplier);

    /**
     * 根据id删除供应商
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
    Supplier findById(Integer id);
}
