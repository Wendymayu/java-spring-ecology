package com.wendy.demo.config;

import com.wendy.demo.wshandler.ClientWebSocketHandler;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.socket.WebSocketHandler;
import org.springframework.web.socket.client.WebSocketClient;
import org.springframework.web.socket.client.standard.StandardWebSocketClient;
import org.springframework.web.socket.config.annotation.EnableWebSocket;

/**
 * @Description TODO
 * @Author wendyma
 * @Date 2024/3/31 21:43
 * @Version 1.0
 */
@Configuration
@EnableWebSocket
public class WebSocketClientConfig {
    @Bean
    public WebSocketClient webSocketClient() {
        return new StandardWebSocketClient();
    }

    @Bean
    public WebSocketHandler webSocketHandler() {
        return new ClientWebSocketHandler();
    }
}
