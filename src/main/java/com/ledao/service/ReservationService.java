package com.ledao.service;

import com.ledao.entity.Reservation;

import java.util.List;
import java.util.Map;

/**
 * 客户预约单Service接口
 *
 * @author LeDao
 * @company
 * @create 2020-02-03 21:05
 */
public interface ReservationService {

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

    /**
     * 根据id查找实体
     *
     * @param id
     * @return
     */
    Reservation findById(Integer id);

    /**
     * 给当天有预约的客户发提醒消息
     */
    void sendInformationToCustomerTodayHaveReservation();
}
