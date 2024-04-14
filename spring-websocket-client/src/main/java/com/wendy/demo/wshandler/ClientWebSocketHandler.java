package com.wendy.demo.wshandler;

import org.springframework.web.socket.CloseStatus;
import org.springframework.web.socket.WebSocketHandler;
import org.springframework.web.socket.WebSocketMessage;
import org.springframework.web.socket.WebSocketSession;

/**
 * @Description TODO
 * @Author wendyma
 * @Date 2024/3/31 21:42
 * @Version 1.0
 */
public class ClientWebSocketHandler implements WebSocketHandler {
    @Override
    public void afterConnectionEstablished(WebSocketSession session) {
        // 连接建立后的处理逻辑
        System.out.println("connection opened.");
    }

    @Override
    public void handleMessage(WebSocketSession session, WebSocketMessage<?> message) {
        // 接收到消息的处理逻辑
        System.out.println(String.format("the message that client sended is %s", message.getPayload()));
    }

    @Override
    public void handleTransportError(WebSocketSession session, Throwable exception) {
        // 发生传输错误的处理逻辑
        System.out.println("connection error.");
    }

    @Override
    public void afterConnectionClosed(WebSocketSession session, CloseStatus closeStatus) {
        // 连接关闭后的处理逻辑
        System.out.println("connection closed." + session.getId());
    }

    @Override
    public boolean supportsPartialMessages() {
        return false;
    }
}
