package com.wendy.jpa.controller;

import com.wendy.jpa.entity.PageVo;
import com.wendy.jpa.entity.TagVo;
import com.wendy.jpa.service.TagService;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

/**
 * @Description TODO
 * @Author wendyma
 * @Date 2023/11/11 15:45
 * @Version 1.0
 */
@RequestMapping("/jpa-demo/v1/tags")
@RestController
public class TagController {
    @Resource
    private TagService tagService;

    @GetMapping
    public PageVo<TagVo> queryAllTags(@RequestParam("offset") int offset, @RequestParam("limit") int limit) {
        return tagService.queryTags(offset, limit);
    }

    @PostMapping
    public String addTag(@RequestParam("tagName") String tagName) {
        return tagService.postTag(tagName);
    }

}
