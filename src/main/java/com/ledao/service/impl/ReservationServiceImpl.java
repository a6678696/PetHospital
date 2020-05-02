package com.ledao.service.impl;

import com.ledao.entity.Information;
import com.ledao.entity.Reservation;
import com.ledao.mapper.*;
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

    @Resource
    private UserMapper userMapper;

    @Resource
    private CustomerMapper customerMapper;

    @Resource
    private InformationMapper informationMapper;

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

    @Override
    public void sendInformationToCustomerTodayHaveReservation() {
        List<Reservation> reservationList = reservationMapper.notRemindSixHoursAndReserveSuccessfully();
        for (Reservation reservation : reservationList) {
            Information information = new Information();
            if (reservation.getType().equals("预约医生")) {
                information.setContent("您今天为您的宠物(" + reservation.getPet().getName() + ")预约了" + reservation.getUser().getTrueName() + "医生,请在今天医院下班前(20:00)到医院,过期预约作废!!");
            } else {
                information.setContent("您今天为您的宠物(" + reservation.getPet().getName() + ")预约了" + reservation.getUser().getTrueName() + "美容师,请在今天医院下班前(20:00)到医院,过期预约作废!!");
            }
            information.setIsRead(0);
            information.setUser(userMapper.findById(1));
            information.setCustomer(reservation.getCustomer());
            informationMapper.add(information);
            reservation.setIsRemind(1);
            reservationMapper.update(reservation);
        }
    }
}
