package com.sxmaps.my.schedule;

import com.franks.util.date.DateUtil;
import com.sxmaps.my.service.IScheduleService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;

/**
 * 类：定时任务
 * 内容：
 * 创建人：付帅
 * 时间：2021/6/19
 */
@Component
public class MySchedule {

    private final Logger logger = LoggerFactory.getLogger(MySchedule.class);

    @Resource
    IScheduleService iScheduleService;

    //每月一号，凌晨1点开始统计
    @Scheduled(cron = "* * 1 1 * ?")
    private void kinds() {
        logger.info("开始统计-种类每月增长数：" + DateUtil.getDate());
        iScheduleService.kind();
        logger.info("开始统计-种类每月增长数：统计结束！");
    }
    //每天，凌晨1点开始统计
    @Scheduled(cron = "* * 1 * * ?")
    private void cowAdd() {
        logger.info("开始统计-牛每日新增情况：" + DateUtil.getDate());
        iScheduleService.cowAdd();
        logger.info("开始统计-牛每日新增情况：统计结束！");
    }
}
