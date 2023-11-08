package com.wendy.demo.controller;

import com.wendy.demo.aop.UserAuth;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Description TODO
 * @Author wendyma
 * @Date 2023/11/8 22:17
 * @Version 1.0
 */
@UserAuth
@RequestMapping("/spring-aop/v1")
@RestController
public class HelloController {
    @UserAuth
    @GetMapping("/hello")
    public String hello() {
        return HttpStatus.OK.getReasonPhrase();
    }

    @GetMapping("/fuck")
    public String fuck() {
        return HttpStatus.NOT_FOUND.getReasonPhrase();
    }
}
