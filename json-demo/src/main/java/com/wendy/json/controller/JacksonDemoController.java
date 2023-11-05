package com.wendy.json.controller;

import com.wendy.json.entity.Connector;
import com.wendy.json.service.JacksonDemoService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

/**
 * @Description TODO
 * @Author wendyma
 * @Date 2023/10/8 21:20
 * @Version 1.0
 */
@RestController
@RequestMapping("/json-demo/v1/")
public class JacksonDemoController {
    @Resource
    private JacksonDemoService jacksonDemoService;

    @PostMapping("/write-json")
    public ResponseEntity<String> writeJson(@RequestBody Connector connector) {
        String result = jacksonDemoService.writeJson(connector);
        return new ResponseEntity<>(result, HttpStatus.OK);
    }

    @GetMapping("/read-json")
    public ResponseEntity<Connector> readJson() {
        Connector connector = jacksonDemoService.readJson();
        return new ResponseEntity<>(connector, HttpStatus.OK);
    }

    @GetMapping("/json-property")
    public ResponseEntity<Object> getJsonProperty(@RequestParam String path) {
        Object property = jacksonDemoService.getJsonProperty(path);
        return new ResponseEntity<>(property, HttpStatus.OK);
    }
}