package com.ledao.quartz;

import com.ledao.service.ReservationService;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;

import javax.annotation.Resource;

/**
 * 创建明天的预约单
 *
 * @author LeDao
 * @company
 * @create 2020-05-29 15:05
 */
@Configuration
@EnableScheduling
public class CreateReservationForTomorrow {

    @Resource
    private ReservationService reservationService;

    /**
     * 创建明天的预约单
     */
    @Scheduled(cron = "0 0 0 * * ?")
    public void work() {
        reservationService.CreateReservationForTomorrow();
    }
}
