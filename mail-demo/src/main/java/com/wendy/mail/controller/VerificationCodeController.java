package com.wendy.mail.controller;

import com.wendy.mail.service.VerificationCodeService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * @Description 验证码控制器
 * @Author wendyma
 * @Date 2023/9/29 19:57
 * @Version 1.0
 */
@RestController
@RequestMapping("/mail/v1/")
public class VerificationCodeController {
    @Resource
    private VerificationCodeService verificationCodeService;

    @PostMapping("/verification-code/send")
    public ResponseEntity<String> sendCode(@RequestParam("email") String email) {
        String result = verificationCodeService.sendCode(email);
        return new ResponseEntity(result, HttpStatus.OK);
    }
}
