package com.macro.mall.component;

import lombok.extern.slf4j.Slf4j;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

/**
 * @author guoyf
 * @Date 2020/10/22
 */
@Component
@Slf4j
public class OrderTimeOutCancelTask {

    @Scheduled(cron = "0/5 * * ? * ?")
    private void cancelTimeOutOrder(){
        //TODO 完善定时任务
        log.info("取消订单并且释放锁定库存！！！");
    }
}
