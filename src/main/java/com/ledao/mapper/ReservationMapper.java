package com.ledao.mapper;

import com.ledao.entity.Reservation;

import java.util.List;
import java.util.Map;

/**
 * 客户预约单Mapper接口
 *
 * @author LeDao
 * @company
 * @create 2020-02-03 20:25
 */
public interface ReservationMapper {

    /**
     * 分页分条件查询预约单
     *
     * @param map
     * @return
     */
    List<Reservation> list(Map<String, Object> map);

    /**
     * 获取记录数
     *
     * @param map
     * @return
     */
    Long getCount(Map<String, Object> map);

    /**
     * 添加预约单
     *
     * @param reservation
     * @return
     */
    Integer add(Reservation reservation);

    /**
     * 修改预约单
     *
     * @param reservation
     * @return
     */
    Integer update(Reservation reservation);

    /**
     * 删除实体
     *
     * @param id
     * @return
     */
    Integer delete(Integer id);
}
