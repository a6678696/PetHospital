package com.ledao.service;

import com.ledao.entity.Vaccine;

import java.util.List;
import java.util.Map;

/**
 * 疫苗注射记录Service接口
 *
 * @author LeDao
 * @company
 * @create 2020-03-18 23:59
 */
public interface VaccineService {

    /**
     * 根据条件查询疫苗注射记录
     *
     * @param map
     * @return
     */
    List<Vaccine> list(Map<String, Object> map);

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
     * @param vaccine
     * @return
     */
    Integer add(Vaccine vaccine);

    /**
     * 修改病历单
     *
     * @param vaccine
     * @return
     */
    Integer update(Vaccine vaccine);

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
    Vaccine findById(Integer id);
}
