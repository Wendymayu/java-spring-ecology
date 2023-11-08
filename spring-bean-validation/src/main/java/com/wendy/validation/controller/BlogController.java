package com.wendy.validation.controller;

import com.wendy.validation.entity.BlogReq;
import org.springframework.http.HttpStatus;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

/**
 * @Description TODO
 * @Author wendyma
 * @Date 2023/11/7 23:47
 * @Version 1.0
 */
@Validated
@RestController
@RequestMapping("/bean-validation/v1/blogs")
public class BlogController {
    @PostMapping("/post")
    public String postBlog(@Valid @RequestBody BlogReq blogReq) {
        // 业务逻辑省略
        System.out.println("User register success.");
        return HttpStatus.OK.getReasonPhrase();
    }
}
