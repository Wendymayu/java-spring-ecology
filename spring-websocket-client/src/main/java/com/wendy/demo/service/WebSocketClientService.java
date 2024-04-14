package com.wendy.demo.service;

import com.wendy.demo.entity.MessageBody;

import java.io.IOException;

/**
 * @Description TODO
 * @Author wendyma
 * @Date 2024/3/31 21:44
 * @Version 1.0
 */
public interface WebSocketClientService {
    void connect();

    void sendMessage(MessageBody messageBody) throws IOException;

    void disconnect() throws IOException;
}
