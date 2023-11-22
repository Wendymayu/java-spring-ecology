package com.wendy.demo.controller;

import com.wendy.demo.entity.BookVo;
import com.wendy.demo.entity.PageVo;
import com.wendy.demo.service.BookService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * @Description TODO
 * @Author wendyma
 * @Date 2023/11/22 23:16
 * @Version 1.0
 */
@RestController
@RequestMapping(value = "/flyway-demo/v1/books")
public class BookController {
    @Resource
    private BookService bookService;

    @GetMapping
    public PageVo<BookVo> queryAllBooks(@RequestParam("offset") int offset,
                                        @RequestParam("limit") int limit) {
        return bookService.queryAllBooks(offset, limit);
    }
}
