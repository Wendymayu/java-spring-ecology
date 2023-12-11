package com.wendy.demo.controller;

import com.wendy.demo.utils.JwtUtils;
import org.springframework.web.bind.annotation.*;

/**
 * @Description TODO
 * @Author wendyma
 * @Date 2023/12/11 22:39
 * @Version 1.0
 */
@RestController
@RequestMapping("/jwt-demo/v1/token")
public class TokenController {
    @PostMapping("/generate")
    public String generateToken(@RequestBody String userName) {
        return JwtUtils.generateToken(userName);
    }

    @GetMapping("/verify")
    public String checkToken(@RequestHeader("Authorization") String token,
                             @RequestParam String userName) {
        return JwtUtils.verifyToken(token, userName) ? "valid" : "invalid";
    }

}
