package com.wendy.kafka.controller;

import com.wendy.kafka.entity.UserInfo;
import com.wendy.kafka.service.UserService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * @Description 用户控制类
 * @Author wendyma
 * @Date 2023/11/9 23:09
 * @Version 1.0
 */
@RequestMapping("/kafka-demo/v1/users")
@RestController
public class UserController {
    @Resource
    private UserService userService;

    @PostMapping("/register")
    public ResponseEntity<String> register(@RequestBody UserInfo userInfo) {
        String result = userService.register(userInfo);
        return new ResponseEntity<>(result, HttpStatus.CREATED);
    }
}
