package com.wendy.kafka.service;

import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

/**
 * @Description TODO
 * @Author wendyma
 * @Date 2023/11/10 23:34
 * @Version 1.0
 */
@Service
public class KafkaConsumer {
    @KafkaListener(topics = "email_topic", groupId = "my-group")
    public void consume(String message) {
        System.out.println("Received message: " + message);
    }
}
