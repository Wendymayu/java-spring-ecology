package com.wendy.demo.controller;

import com.wendy.demo.service.HelloService;
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
 * @Date 2023/11/13 22:33
 * @Version 1.0
 */
@RequestMapping("/exception-demo/v1/")
@RestController
public class HelloController {
    @Resource
    private HelloService helloService;

    @GetMapping("/hello")
    public ResponseEntity<String> hello(@RequestParam("name") String name) {
        String result = helloService.hello(name);
        return new ResponseEntity<>(result, HttpStatus.OK);
    }
}
