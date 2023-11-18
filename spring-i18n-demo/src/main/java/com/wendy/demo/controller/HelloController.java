package com.wendy.demo.controller;

import com.wendy.demo.i18n.MessageUtils;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * @Description TODO
 * @Author wendyma
 * @Date 2023/11/17 22:02
 * @Version 1.0
 */
@RequestMapping("/i18n-demo/v1/")
@RestController
public class HelloController {
    @Resource
    private MessageUtils messageUtils;

    @GetMapping("/hello")
    public ResponseEntity<String> hello(@RequestParam("name") String name) {
        String result = name + " " + messageUtils.getMessage("welcome.info");
        return new ResponseEntity<>(result, HttpStatus.OK);
    }
}
