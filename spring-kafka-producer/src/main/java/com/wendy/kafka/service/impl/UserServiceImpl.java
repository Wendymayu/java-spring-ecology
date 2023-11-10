package com.wendy.kafka.service.impl;

import com.wendy.common.utils.JsonUtils;
import com.wendy.kafka.entity.UserInfo;
import com.wendy.kafka.entity.UserInfoMessage;
import com.wendy.kafka.service.UserService;
import org.springframework.beans.BeanUtils;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * @Description 用户业务实现类
 * @Author wendyma
 * @Date 2023/11/9 23:15
 * @Version 1.0
 */
@Service
public class UserServiceImpl implements UserService {
    @Resource
    private KafkaTemplate<String, Object> kafkaTemplate;

    @Override
    public String register(UserInfo userInfo) {
        // 1.保存注册的用户信息
        // TODO

        // 2.给用户发送注册确认邮件
        UserInfoMessage userInfoMessage = new UserInfoMessage();
        BeanUtils.copyProperties(userInfo, userInfoMessage);
        kafkaTemplate.send("email_topic", JsonUtils.toJson(userInfoMessage));
        return "success";
    }
}
