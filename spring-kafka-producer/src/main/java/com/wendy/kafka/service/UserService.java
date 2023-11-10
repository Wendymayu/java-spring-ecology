package com.wendy.kafka.service;

import com.wendy.kafka.entity.UserInfo;

/**
 * @Description TODO
 * @Author wendyma
 * @Date 2023/11/9 23:14
 * @Version 1.0
 */
public interface UserService {
    String register(UserInfo userInfo);
}