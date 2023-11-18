package com.wendy.demo.service.impl;

import com.wendy.demo.service.HelloService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

import java.util.Date;

/**
 * @Description TODO
 * @Author wendyma
 * @Date 2023/11/18 13:21
 * @Version 1.0
 */
@Slf4j
@Service
public class HelloServiceImpl implements HelloService {
    @Async(value = "threadPool1")
    @Override
    public void hello(String name) {
        try {
            log.info("Task start to execute at {}", new Date());
            // 模拟耗时的IO任务
            Thread.sleep(10000);
            log.info("Task finished at {}", new Date());
        } catch (InterruptedException e) {
            log.error("hello execute failed, {}", e.getMessage());
        }
    }
}
