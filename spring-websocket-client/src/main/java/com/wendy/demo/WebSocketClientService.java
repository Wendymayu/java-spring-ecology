package com.wendy.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.socket.WebSocketHandler;
import org.springframework.web.socket.WebSocketSession;
import org.springframework.web.socket.client.WebSocketClient;

import javax.annotation.PostConstruct;
import javax.annotation.Resource;

/**
 * @Description TODO
 * @Author wendyma
 * @Date 2024/3/31 21:44
 * @Version 1.0
 */
@Component
public class WebSocketClientService {
    private final WebSocketClient webSocketClient;
    private final WebSocketHandler webSocketHandler;

    @Autowired
    public WebSocketClientService(WebSocketClient webSocketClient, WebSocketHandler webSocketHandler) {
        this.webSocketClient = webSocketClient;
        this.webSocketHandler = webSocketHandler;
    }

    @PostConstruct
    public void init(){
        connect();
    }

    public void connect() {
        try {
            WebSocketSession session = webSocketClient.doHandshake(webSocketHandler, "ws://localhost:8080/websocket-demo/v1/hello").get();
            // 连接建立后的逻辑
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void sendMessage(String message) {
        // 发送消息的逻辑
    }

    public void disconnect() {
        // 断开连接的逻辑
    }
}
