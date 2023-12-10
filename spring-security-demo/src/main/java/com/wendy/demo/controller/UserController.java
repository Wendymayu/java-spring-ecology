package com.wendy.demo.controller;

import com.wendy.demo.entity.SysUser;
import com.wendy.demo.service.UserService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * @Description TODO
 * @Author wendyma
 * @Date 2023/12/7 0:06
 * @Version 1.0
 */
@RestController
@RequestMapping(value = "/security-demo/v1/user")
public class UserController {
    @Resource
    private UserService userService;

    @PostMapping("/register")
    public String register(@RequestBody SysUser sysUser) {
        return userService.register(sysUser);
    }

    @PostMapping("/login")
    public String login(@RequestBody SysUser sysUser) {
        return userService.login(sysUser);
    }
}

