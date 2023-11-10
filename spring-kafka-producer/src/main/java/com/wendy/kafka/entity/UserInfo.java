package com.wendy.kafka.entity;

import lombok.Data;

/**
 * @Description TODO
 * @Author wendyma
 * @Date 2023/11/9 23:11
 * @Version 1.0
 */
@Data
public class UserInfo {
    private String userName;

    private String password;

    private String email;
}
