package com.wendy.scheduler.task;

import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.util.Date;

/**
 * @Description 定时统计网站数据
 * @Author wendyma
 * @Date 2023/11/6 22:06
 * @Version 1.0
 */
@Component
public class StatisticsTask {

    /**
     * create by: wendyMa
     * description: 每分钟统计一次网站的活跃用户
     * create time: 2023/11/6 22:10
     *
     * @return
     */
    @Scheduled(cron = "0 * * * * ?")
    public void countTotalUser() {
        // 计算网站活跃用户
        // TODO
        System.out.println("网站活跃用户数：" + new Date());
    }

    /**
     * create by: wendyMa
     * description: 每天凌晨3点执行
     * create time: 2023/11/6 22:10
     *
     * @return
     */
    @Scheduled(cron = "0 0 3 * * ? ")
    public void executeAt3am() {
        System.out.println("This task will execute at 3:00 am");
    }

    /**
     * create by: wendyMa
     * description: 可配置的cron表达式
     * create time: 2023/11/6 22:10
     *
     * @return
     */
    @Scheduled(cron = "${statistics.cron:30 * * * * ?}")
    public void execute() {
        System.out.println("This task has executed at" + new Date());
    }
}
