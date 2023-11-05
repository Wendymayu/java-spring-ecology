package com.wendy.controller;

import com.wendy.service.MyPropertiesService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * @Description TODO
 * @Author wendyma
 * @Date 2023/10/2 14:41
 * @Version 1.0
 */
@RestController
@RequestMapping("/properties-demo/v1/")
public class MyPropertiesController {
    @Resource
    private MyPropertiesService myPropertiesService;

    @GetMapping("/datasource/url")
    public String getProperty(@RequestParam String key) {
        return myPropertiesService.getProperty(key);
    }
}
