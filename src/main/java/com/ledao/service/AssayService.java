package com.ledao.service;

import com.ledao.entity.Assay;

import java.util.List;
import java.util.Map;

/**
 * 化验记录Service接口
 *
 * @author LeDao
 * @company
 * @create 2020-03-18 23:59
 */
public interface AssayService {

    /**
     * 根据条件查询化验记录
     *
     * @param map
     * @return
     */
    List<Assay> list(Map<String, Object> map);

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
     * @param assay
     * @return
     */
    Integer add(Assay assay);

    /**
     * 修改病历单
     *
     * @param assay
     * @return
     */
    Integer update(Assay assay);

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
    Assay findById(Integer id);
}
