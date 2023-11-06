package com.wendy.scheduler;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

@EnableScheduling
@SpringBootApplication
public class SpringSchedulerDemoApplication {
    public static void main(String[] args) {
        SpringApplication.run(SpringSchedulerDemoApplication.class, args);
    }
}
