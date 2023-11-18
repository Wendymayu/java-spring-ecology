package com.wendy.demo.rabbit;

import com.wendy.common.utils.JsonUtils;
import com.wendy.demo.entity.UserInfoMessage;
import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.core.Message;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

import java.nio.charset.StandardCharsets;

/**
 * @Description TODO
 * @Author wendyma
 * @Date 2023/11/9 23:37
 * @Version 1.0
 */
@Slf4j
@Component
public class UserMessageReceiver {
    @RabbitListener(queues = "email_queue")
    public void receiveUserRegistry(Message msg) {
        byte[] body = msg.getBody();
        String content = new String(body, StandardCharsets.UTF_8);
        UserInfoMessage userInfoMessage = JsonUtils.json2Object(content, UserInfoMessage.class);
        log.info("Start to send email, userName={}, email={}", userInfoMessage.getUserName(), userInfoMessage.getEmail());
        // 给用户发送注册确认邮件
        // TODO
    }

}
