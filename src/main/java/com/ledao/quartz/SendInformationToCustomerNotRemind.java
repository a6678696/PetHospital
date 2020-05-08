package com.ledao.quartz;

import com.ledao.service.ReservationService;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;

import javax.annotation.Resource;

/**
 * 医院上班后系统自动给当天有预约的客户发送提醒消息(假定医院8点开始上班)
 *
 * @author LeDao
 * @company
 * @create 2020-05-02 12:48
 */
@Configuration
@EnableScheduling
public class SendInformationToCustomerNotRemind {

    @Resource
    private ReservationService reservationService;

    /**
     * 医院上班后系统自动给当天有预约的客户发送提醒消息(假定医院8点开始上班)
     */
    @Scheduled(cron = "*/20 * * * * ?")
    public void work() {
        reservationService.sendInformationToCustomerTodayHaveReservation();
    }
}
