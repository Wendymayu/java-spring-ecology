package com.wendy.redis.controller;

import com.wendy.redis.entity.BlogVo;
import com.wendy.redis.service.BlogService;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

/**
 * @Description TODO
 * @Author wendyma
 * @Date 2023/11/11 15:36
 * @Version 1.0
 */
@RequestMapping("/redis-demo/v1/blogs")
@RestController
public class BlogController {
    @Resource
    private BlogService blogService;

    @PostMapping
    public BlogVo addBlog(@RequestBody BlogVo blogVo) {
        return blogService.addBlog(blogVo);
    }

    @GetMapping("/{id}")
    public BlogVo queryBlog(@PathVariable("id") String id) {
        return blogService.queryBlog(id);
    }

    @PutMapping("/{id}")
    public BlogVo updateBlog(@PathVariable("id") String id, @RequestBody BlogVo blogVo) {
        return blogService.updateBlog(id, blogVo);
    }

    @DeleteMapping("/{id}")
    public String deleteBlog(@PathVariable("id") String id) {
        blogService.deleteBlog(id);
        return "success";
    }
}
