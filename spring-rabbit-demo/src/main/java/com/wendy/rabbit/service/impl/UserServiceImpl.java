package com.wendy.rabbit.service.impl;

import com.wendy.common.utils.JsonUtils;
import com.wendy.rabbit.config.RabbitConstants;
import com.wendy.rabbit.entity.UserInfo;
import com.wendy.rabbit.entity.UserInfoMessage;
import com.wendy.rabbit.service.UserService;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.BeanUtils;
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
    private RabbitTemplate rabbitTemplate;

    @Override
    public String register(UserInfo userInfo) {
        // 1.保存注册的用户信息
        // TODO

        // 2.给用户发送注册确认邮件
        UserInfoMessage userInfoMessage = new UserInfoMessage();
        BeanUtils.copyProperties(userInfo, userInfoMessage);
        rabbitTemplate.convertAndSend(RabbitConstants.DIRECT_EXCHANGE,
                RabbitConstants.EMAIL_DIRECT_ROUTINGKEY, JsonUtils.toJson(userInfoMessage));
        return null;
    }
}
