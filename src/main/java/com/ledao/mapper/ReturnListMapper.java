package com.ledao.mapper;

import com.ledao.entity.ReturnList;

import java.util.List;
import java.util.Map;

/**
 * 退货单mapper接口
 *
 * @author LeDao
 * @company
 * @create 2020-01-18 13:53
 */
public interface ReturnListMapper {

    /**
     * 获取当天最大退货单号
     *
     * @return
     */
    String getTodayMaxReturnNumber();

    /**
     * 根据条件查询退货单信息
     *
     * @param map
     * @return
     */
    List<ReturnList> list(Map<String, Object> map);

    /**
     * 添加退货单
     *
     * @param returnList
     * @return
     */
    Integer add(ReturnList returnList);

    /**
     * 修改退货单
     *
     * @param returnList
     * @return
     */
    Integer update(ReturnList returnList);

    /**
     * 根据id查询实体
     *
     * @param id
     * @return
     */
    ReturnList findById(Integer id);

    /**
     * 根据退货单号查询订单
     *
     * @param returnName
     * @return
     */
    ReturnList findByReturnNumber(String returnName);

    /**
     * 根据id删除退货单信息
     *
     * @param id
     * @return
     */
    Integer delete(Integer id);
}
