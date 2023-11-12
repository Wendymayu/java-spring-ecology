package com.wendy.jpa.controller;

import com.wendy.jpa.entity.BlogReq;
import com.wendy.jpa.entity.BlogVo;
import com.wendy.jpa.service.BlogService;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

/**
 * @Description TODO
 * @Author wendyma
 * @Date 2023/11/11 15:36
 * @Version 1.0
 */
@RequestMapping("/jpa-demo/v1/blogs")
@RestController
public class BlogController {
    @Resource
    private BlogService blogService;

    @PostMapping("/post")
    public String postBlog(@RequestBody BlogReq blogReq) {
        // 业务逻辑省略
        System.out.println("User register success.");
        return HttpStatus.OK.getReasonPhrase();
    }

    @GetMapping("/{id}")
    public BlogVo postBlog(@PathVariable("id") long id) {
        return blogService.queryBlog(id);
    }
}
