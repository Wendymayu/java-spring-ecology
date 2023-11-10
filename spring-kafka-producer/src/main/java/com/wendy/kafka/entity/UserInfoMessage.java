package com.wendy.kafka.entity;

import lombok.Data;

/**
 * @Description 用户注册时发送给邮件服务的用户信息
 * @Author wendyma
 * @Date 2023/11/9 23:33
 * @Version 1.0
 */
@Data
public class UserInfoMessage {
    private String userName;

    private String email;
}
