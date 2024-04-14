package com.wendy.demo.endpoint;

import javax.websocket.Session;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 * @Description TODO
 * @Author wendyma
 * @Date 2024/4/14 13:22
 * @Version 1.0
 */
public class WebSocketSessionManager {
    private static final Map<String, Session> map = new ConcurrentHashMap<>();

    public static void addSesion(String userId, Session session) {
        map.put(userId, session);
    }

    public static Session getSession(String userId) {
        return map.get(userId);
    }

    public static void removeSesion(String userId){
        map.remove(userId);
    }
}
