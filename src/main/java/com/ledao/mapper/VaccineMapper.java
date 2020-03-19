package com.ledao.mapper;

import com.ledao.entity.Vaccine;

import java.util.List;
import java.util.Map;

/**
 * 疫苗注射记录Mapper接口
 *
 * @author LeDao
 * @company
 * @create 2020-03-18 23:45
 */
public interface VaccineMapper {

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
     * 添加疫苗注射记录
     *
     * @param vaccine
     * @return
     */
    Integer add(Vaccine vaccine);

    /**
     * 修改疫苗注射记录
     *
     * @param vaccine
     * @return
     */
    Integer update(Vaccine vaccine);

    /**
     * 根据id删除疫苗注射记录
     *
     * @param id
     * @return
     */
    Integer delete(Integer id);

    /**
     * 根据id查询疫苗注射记录
     *
     * @param id
     * @return
     */
    Vaccine findById(Integer id);
}
