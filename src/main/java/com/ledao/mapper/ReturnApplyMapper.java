package com.ledao.mapper;

import com.ledao.entity.ReturnApply;

import java.util.List;
import java.util.Map;

/**
 * 客户退货申请Mapper接口
 *
 * @author LeDao
 * @company
 * @create 2020-06-05 21:43
 */
public interface ReturnApplyMapper {

    /**
     * 条件查询客户退货申请
     *
     * @param map
     * @return
     */
    List<ReturnApply> list(Map<String, Object> map);

    /**
     * 获取记录数
     *
     * @param map
     * @return
     */
    Long getCount(Map<String, Object> map);

    /**
     * 添加客户退货申请
     *
     * @param returnApply
     * @return
     */
    Integer add(ReturnApply returnApply);

    /**
     * 修改客户退货申请
     *
     * @param returnApply
     * @return
     */
    Integer update(ReturnApply returnApply);

    /**
     * 删除客户退货申请
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
    ReturnApply findById(Integer id);
}
