package com.wendy.demo.service;

import com.wendy.common.utils.JsonUtils;
import com.wendy.demo.entity.MessageBody;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.socket.TextMessage;
import org.springframework.web.socket.WebSocketHandler;
import org.springframework.web.socket.WebSocketMessage;
import org.springframework.web.socket.WebSocketSession;
import org.springframework.web.socket.client.WebSocketClient;

import java.io.IOException;

/**
 * @Description TODO
 * @Author wendyma
 * @Date 2024/4/14 15:03
 * @Version 1.0
 */
@Component
public class WebSocketClientServiceImpl implements WebSocketClientService{
    private final WebSocketClient webSocketClient;

    private final WebSocketHandler webSocketHandler;

    private WebSocketSession webSocketSession;

    @Autowired
    public WebSocketClientServiceImpl(WebSocketClient webSocketClient, WebSocketHandler webSocketHandler) {
        this.webSocketClient = webSocketClient;
        this.webSocketHandler = webSocketHandler;
    }

    public void connect() {
        try {
            webSocketSession = webSocketClient.doHandshake(webSocketHandler, "ws://localhost:8080/websocket-server/v1/hello?userId=idea").get();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void sendMessage(MessageBody messageBody) throws IOException {
        messageBody.setSendTime(System.currentTimeMillis());
        String content = JsonUtils.toJson(messageBody);
        WebSocketMessage textMessage = new TextMessage(content);
        webSocketSession.sendMessage(textMessage);
    }

    public void disconnect() throws IOException{
        webSocketSession.close();
    }
}
