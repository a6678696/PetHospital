package com.ledao.service.impl;

import com.ledao.entity.Reservation;
import com.ledao.mapper.ReservationMapper;
import com.ledao.service.ReservationService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;
import java.util.Map;

/**
 * 客户预约单Service实现类
 *
 * @author LeDao
 * @company
 * @create 2020-02-03 21:06
 */
@Service("reservationService")
public class ReservationServiceImpl implements ReservationService {

    @Resource
    private ReservationMapper reservationMapper;

    @Override
    public List<Reservation> list(Map<String, Object> map) {
        return reservationMapper.list(map);
    }

    @Override
    public Long getCount(Map<String, Object> map) {
        return reservationMapper.getCount(map);
    }

    @Override
    public Integer add(Reservation reservation) {
        return reservationMapper.add(reservation);
    }

    @Override
    public Integer update(Reservation reservation) {
        return reservationMapper.update(reservation);
    }

    @Override
    public Integer delete(Integer id) {
        return reservationMapper.delete(id);
    }

    @Override
    public Reservation findById(Integer id) {
        return reservationMapper.findById(id);
    }
}
