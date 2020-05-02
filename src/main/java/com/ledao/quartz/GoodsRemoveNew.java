package com.ledao.quartz;

import com.ledao.service.GoodsService;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;

import javax.annotation.Resource;

/**
 * 将发布日期超过3个月的商品的"新品标签"移除
 *
 * @author LeDao
 * @company
 * @create 2020-05-01 20:06
 */
@Configuration
@EnableScheduling
public class GoodsRemoveNew {

    @Resource
    private GoodsService goodsService;

    /**
     * 每天凌晨1点将发布日期超过3个月的商品"新品"标签去掉
     */
    @Scheduled(cron = "0 0 1 * * ?")
    public void work() {
        goodsService.goodsNewToOld();
    }
}
