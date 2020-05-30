package com.ledao.quartz;

import com.ledao.service.SaleListService;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;

import javax.annotation.Resource;

/**
 * 超过14天的订单自动确认收货
 *
 * @author LeDao
 * @company
 * @create 2020-05-30 13:31
 */
@Configuration
@EnableScheduling
public class AutomaticReceiptConfirmation {

    @Resource
    private SaleListService saleListService;

    /**
     * 超过14天的订单自动确认收货
     */
    @Scheduled(cron = "0 */1 * * * ?")
    public void work() {
        saleListService.automaticReceiptConfirmation();
    }
}
