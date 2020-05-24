package com.ledao.quartz;

import com.ledao.service.SaleListService;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;

import javax.annotation.Resource;

/**
 * 取消客户提交的超过一天未支付的订单
 *
 * @author LeDao
 * @company
 * @create 2020-05-09 20:53
 */
@Configuration
@EnableScheduling
public class CancelOrderOverOneDay {

    @Resource
    private SaleListService saleListService;

    /**
     * 取消客户提交的超过一天未支付的订单(每分钟运行一次)
     */
    @Scheduled(cron = "0 */1 * * * ?")
    public void work() {
        saleListService.cancelOrderOverOneDay();
    }
}
