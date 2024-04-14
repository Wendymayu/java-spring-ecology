package com.wendy.demo.controller;

import com.wendy.demo.entity.MessageBody;
import com.wendy.demo.service.WebSocketClientService;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.io.IOException;

/**
 * @Description TODO
 * @Author wendyma
 * @Date 2024/4/14 14:29
 * @Version 1.0
 */
@RestController
@RequestMapping(value = "/websocket-client/v1")
public class ClientController {
    @Resource
    private WebSocketClientService webSocketClientService;

    @PostMapping("/connect")
    public String connect() {
        webSocketClientService.connect();
        return HttpStatus.OK.getReasonPhrase();
    }

    @PostMapping("/send")
    public String send(@RequestBody MessageBody messageBody) throws IOException {
        webSocketClientService.sendMessage(messageBody);
        return HttpStatus.OK.getReasonPhrase();
    }
}
