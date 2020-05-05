package com.ledao.service.impl;

import com.ledao.entity.Information;
import com.ledao.entity.Reservation;
import com.ledao.entity.User;
import com.ledao.mapper.*;
import com.ledao.service.ReservationService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.text.SimpleDateFormat;
import java.util.*;

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
        List<Reservation> reservationList = reservationMapper.notRemindAndReserveSuccessfully();
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

    @Override
    public void reservationArrangeUser() {
        SimpleDateFormat sdf=new SimpleDateFormat("yyyy年MM月dd日");
        List<Reservation> reservationList = reservationMapper.notArrangeTodayWhenCreate();
        Map<String,Object> map=new HashMap<>(16);
        map.put("type", 2);
        List<User> doctorListForReservation = userMapper.list(map);
        List<User> doctorListForReservation2 = new ArrayList<>();
        map.put("type", 3);
        List<User> beauticianListForReservation = userMapper.list(map);
        List<User> beauticianListForReservation2 = new ArrayList<>();
        for (Reservation reservation : reservationList) {
            if (reservation.getType().equals("预约医生")) {
                Collections.shuffle(doctorListForReservation);
                User doctorForReservation = doctorListForReservation.get(0);
                reservation.setUser(doctorForReservation);
                reservation.setStatus(1);
                reservationMapper.update(reservation);
                doctorListForReservation2.add(doctorForReservation);
                doctorListForReservation.remove(doctorForReservation);
                if (doctorListForReservation.size() == 0) {
                    for (User user : doctorListForReservation2) {
                        doctorListForReservation.add(user);
                    }
                    doctorListForReservation2 = new ArrayList<>();
                }
                Information information = new Information();
                information.setContent("由于长时间没人接受您的预约,系统自动为您的宠物(" + reservation.getPet().getName() + ")安排了" + reservation.getUser().getTrueName() + "医生,请在"+sdf.format(reservation.getReserveDate())+"医院下班前(20:00)到医院,过期预约作废!!");
                information.setIsRead(0);
                information.setUser(userMapper.findById(1));
                information.setCustomer(reservation.getCustomer());
                informationMapper.add(information);
            } else {
                Collections.shuffle(beauticianListForReservation);
                User beauticianForReservation = beauticianListForReservation.get(0);
                reservation.setUser(beauticianForReservation);
                reservation.setStatus(1);
                reservationMapper.update(reservation);
                beauticianListForReservation2.add(beauticianForReservation);
                beauticianListForReservation.remove(beauticianForReservation);
                if (beauticianListForReservation.size()==0) {
                    for (User user : beauticianListForReservation2) {
                        beauticianListForReservation.add(user);
                    }
                    beauticianListForReservation2 = new ArrayList<>();
                }
                Information information = new Information();
                information.setContent("由于长时间没人接受您的预约,系统自动为您的宠物(" + reservation.getPet().getName() + ")安排了" + reservation.getUser().getTrueName() + "美容师,请在"+sdf.format(reservation.getReserveDate())+"医院下班前(20:00)到医院,过期预约作废!!");
                information.setIsRead(0);
                information.setUser(userMapper.findById(1));
                information.setCustomer(reservation.getCustomer());
                informationMapper.add(information);
            }
        }
    }
}
