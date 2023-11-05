package com.wendy.xml.controller;

import com.wendy.xml.entity.PomReq;
import com.wendy.xml.service.Dom4jService;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;

/**
 * @Description 以pom文件为例练手dom4j
 * @Author wendyma
 * @Date 2023/10/1 5:24
 * @Version 1.0
 */
@RestController
@RequestMapping("/xml-demo/v1/")
public class Dom4jController {
    @Resource
    private Dom4jService dom4jService;

    @PostMapping("/pom/generator")
    public String generatePom(@RequestBody PomReq pomReq) {
        return dom4jService.generatePom(pomReq);
    }

    @GetMapping("/pom/dependencies")
    public List<String> getDependencies() {
        return dom4jService.getDependencies();
    }
}
