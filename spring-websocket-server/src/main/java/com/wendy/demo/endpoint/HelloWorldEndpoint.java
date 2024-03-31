package com.wendy.demo.endpoint;

import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import javax.websocket.*;
import javax.websocket.server.ServerEndpoint;
import java.io.IOException;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 * @Description TODO
 * @Author wendyma
 * @Date 2024/3/31 16:06
 * @Version 1.0
 */
@Component
@ServerEndpoint("/websocket-demo/v1/hello")
public class HelloWorldEndpoint {
    private static final Map<String, Session> map = new ConcurrentHashMap<>();

/*    @PostConstruct
    public void init(){
        map = new ConcurrentHashMap<>();
    }*/

    @OnOpen
    public void onOpen(Session session) {
        System.out.println("connection opened, sessionId is " + session.getId());
        map.put(session.getId(), session);
    }

    @OnClose
    public void onClose(Session session) {
        System.out.println("connection closed." + session.getId());
    }

    @OnMessage
    public void onMessage(String json, Session session) throws IOException {
        System.out.println(String.format("the message that client sended is %s", json));
        Session targetSession = map.get("0");
        targetSession.getBasicRemote().sendText(json);
    }

    @OnError
    public void onError(Session session, Throwable error) {
        System.out.println("connection error.");
        error.printStackTrace();
    }
}
