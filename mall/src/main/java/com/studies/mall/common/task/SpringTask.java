package com.studies.mall.common.task;

import cn.hutool.core.date.DateUtil;
import lombok.extern.slf4j.Slf4j;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.util.Date;

@EnableScheduling
@Component
@Slf4j
public class SpringTask {

    //@Scheduled(cron = "0/10 * * ? * ?")
    private void task(){
        log.info("定时任务执行-{}",DateUtil.format(new Date(),"yyyy-MM-dd HH:mm:ss"));
    }
}
