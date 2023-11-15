package com.wendy.demo.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Description TODO
 * @Author wendyma
 * @Date 2023/11/15 22:24
 * @Version 1.0
 */
@RequestMapping("/interceptor-demo/v1/")
@RestController
public class HelloController {
    @GetMapping("/hello")
    public ResponseEntity<String> hello(@RequestParam("name") String name) {
        return new ResponseEntity<>("hello " + name, HttpStatus.OK);
    }
}
