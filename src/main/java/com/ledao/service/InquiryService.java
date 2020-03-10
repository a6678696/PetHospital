package com.ledao.service;

import com.ledao.entity.Inquiry;

import java.util.List;
import java.util.Map;

/**
 * 客户问诊Service接口
 *
 * @author LeDao
 * @company
 * @create 2020-03-10 22:38
 */
public interface InquiryService {

    /**
     * 根据条件分页查询客户问诊记录
     *
     * @param map
     * @return
     */
    List<Inquiry> list(Map<String, Object> map);

    /**
     * 获取客户问诊记录数
     *
     * @param map
     * @return
     */
    Long getCount(Map<String, Object> map);

    /**
     * 添加客户问诊
     *
     * @param inquiry
     * @return
     */
    Integer add(Inquiry inquiry);

    /**
     * 修改客户问诊
     *
     * @param inquiry
     * @return
     */
    Integer update(Inquiry inquiry);

    /**
     * 根据id删除客户问诊
     *
     * @param id
     * @return
     */
    Integer delete(Integer id);

    /**
     * 根据id查询客户问诊
     *
     * @param id
     * @return
     */
    Inquiry findById(Integer id);
}
