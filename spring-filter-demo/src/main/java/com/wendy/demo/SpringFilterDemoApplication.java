package com.wendy.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.ServletComponentScan;

@ServletComponentScan("com.wendy.demo.filter")
@SpringBootApplication
public class SpringFilterDemoApplication {
    public static void main(String[] args) {
        SpringApplication.run(SpringFilterDemoApplication.class, args);
    }
}
