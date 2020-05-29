package com.ledao.quartz;

import com.ledao.service.ReservationService;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;

import javax.annotation.Resource;

/**
 * 每天上班(8点)随机自动给未接受的预约单安排医生或美容师
 *
 * @author LeDao
 * @company
 * @create 2020-05-05 15:33
 */
@Configuration
@EnableScheduling
public class ArrangeUserForReservation {

    /*@Resource
    private ReservationService reservationService;*/

    /**
     * 每天上班(8点)随机自动给未接受的预约单安排医生或美容师
     */
    /*@Scheduled(cron = "0 0 8 * * ?")
    public void work() {
        reservationService.reservationArrangeUser();
    }*/
}
