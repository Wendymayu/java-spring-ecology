package com.wendy.demo.controller;

import com.wendy.demo.entity.BlogVo;
import com.wendy.demo.service.BlogService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * @Description TODO
 * @Author wendyma
 * @Date 2023/11/23 23:20
 * @Version 1.0
 */
@RequestMapping("/es-demo/v1/blogs")
@RestController
public class BlogController {
    @Resource
    private BlogService blogService;

    @PostMapping
    public BlogVo addBlog(@RequestBody BlogVo blogVo) {
        blogService.addBlog(blogVo);
        return blogVo;
    }
}
