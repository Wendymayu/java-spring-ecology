package com.wendy.demo.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Description TODO
 * @Author wendyma
 * @Date 2023/12/10 22:36
 * @Version 1.0
 */
@RestController
@RequestMapping("/https-demo/v1/hello")
public class HelloController {
    @GetMapping
    public String hello() {
        return "Hello, World";
    }
}
