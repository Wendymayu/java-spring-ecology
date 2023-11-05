package com.wendy.controller;

import com.wendy.dao.po.BookPo;
import com.wendy.service.TestService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.util.Objects;

/**
 * @Description TODO
 * @Author wendyma
 * @Date 2023/9/17 12:26
 * @Version 1.0
 */
@RestController
@RequestMapping(value = "/rest-demo/v1/request")
public class TestController {
    @Resource
    private TestService testService;

    @GetMapping("/header")
    public ResponseEntity<String> testHeader(HttpServletRequest request) {
        String authorization = request.getHeader("Authorization");
        if (Objects.isNull(authorization)) {
            return new ResponseEntity<>("No authorization", HttpStatus.BAD_REQUEST);
        }
        String result = testService.checkAuthorization(authorization);
        return new ResponseEntity<>(result, HttpStatus.OK);
    }

    @PostMapping("/common/{id}")
    public ResponseEntity<String> commonRequest(@RequestHeader("Authorization") String authorization,
                                                @PathVariable("id") long id,
                                                @RequestParam("key") String key,
                                                @RequestBody BookPo bookPo) {
        if (Objects.isNull(authorization) || authorization.equals("")) {
            return new ResponseEntity<>("No authorization", HttpStatus.BAD_REQUEST);
        }
        if (Objects.isNull(key) || key.equals("")) {
            return new ResponseEntity<>("No queryParam key", HttpStatus.BAD_REQUEST);
        }
        if (Objects.isNull(bookPo)) {
            return new ResponseEntity<>("No requestBody", HttpStatus.BAD_REQUEST);
        }
        return new ResponseEntity<>("success", HttpStatus.OK);
    }
}
