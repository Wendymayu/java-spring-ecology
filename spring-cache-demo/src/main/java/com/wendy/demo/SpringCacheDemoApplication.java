package com.wendy.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;

@EnableCaching
@SpringBootApplication
public class SpringCacheDemoApplication {
    public static void main(String[] args) {
        SpringApplication.run(SpringCacheDemoApplication.class, args);
    }
}
