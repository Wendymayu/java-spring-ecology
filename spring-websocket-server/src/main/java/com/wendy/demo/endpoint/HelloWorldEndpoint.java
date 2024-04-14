package com.wendy.demo.endpoint;

import com.wendy.common.utils.JsonUtils;
import com.wendy.demo.entity.MessageBody;
import org.springframework.stereotype.Component;

import javax.websocket.*;
import javax.websocket.server.ServerEndpoint;
import java.io.IOException;
import java.util.List;
import java.util.Map;
import java.util.Objects;

/**
 * @Description TODO
 * @Author wendyma
 * @Date 2024/3/31 16:06
 * @Version 1.0
 */
@Component
@ServerEndpoint("/websocket-server/v1/hello")
public class HelloWorldEndpoint {
    @OnOpen
    public void onOpen(Session session) {
        System.out.println("connection opened, sessionId is " + session.getId());
        Map<String, List<String>> requestParameterMap = session.getRequestParameterMap();
        String userId = requestParameterMap.get("userId").get(0);
        WebSocketSessionManager.addSesion(userId, session);
    }

    @OnClose
    public void onClose(Session session) {
        System.out.println("connection closed." + session.getId());
        Map<String, List<String>> requestParameterMap = session.getRequestParameterMap();
        String userId = requestParameterMap.get("userId").get(0);
        WebSocketSessionManager.removeSesion(userId);
    }

    @OnMessage
    public void onMessage(String json, Session session) throws IOException {
        System.out.println(String.format("the message that client sended is %s", json));
        long receiveTime = System.currentTimeMillis();
        MessageBody messageBody = JsonUtils.json2Object(json, MessageBody.class);
        messageBody.setReceiveTime(receiveTime);

        // 服务端转发消息给目标客户端
        String to = messageBody.getTo();
        Session targetSession = WebSocketSessionManager.getSession(to);
        if (Objects.isNull(targetSession)) {
            String result = "send failed";
            String response = getServerResponse(messageBody.getFrom(), result, receiveTime);
            session.getBasicRemote().sendText(response);
        } else {
            targetSession.getBasicRemote().sendText(json);

            // 通知发送端消息状态
            String result = "send successfully";
            String response = getServerResponse(messageBody.getFrom(), result, receiveTime);
            session.getBasicRemote().sendText(response);
        }
    }

    /**
     * 服务器处理客户端的消息成功后，通知客户端
     *
     * @param to
     * @return
     */
    private String getServerResponse(String to, String content, long receiveTime) {
        MessageBody messageBody = new MessageBody();
        messageBody.setFrom("system");
        messageBody.setTo(to);
        messageBody.setContent(content);
        messageBody.setReceiveTime(receiveTime);
        messageBody.setSendTime(System.currentTimeMillis());
        return JsonUtils.toJson(messageBody);
    }

    @OnError
    public void onError(Session session, Throwable error) {
        System.out.println("connection error.");
        error.printStackTrace();
    }
}
