package com.wendy.demo.controller;

import com.wendy.demo.entity.BookVo;
import com.wendy.demo.entity.PageVo;
import com.wendy.demo.service.BookService;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

/**
 * @Description TODO
 * @Author wendyma
 * @Date 2023/12/7 0:06
 * @Version 1.0
 */
@RestController
@RequestMapping(value = "/security-demo/v1/books")
public class BookController {
    @Resource
    private BookService bookService;

    @PreAuthorize("hasAuthority('demo:book:read')")
    @GetMapping
    public PageVo<BookVo> queryAllBooks(@RequestParam("page") int page,
                                        @RequestParam("size") int size) {
        return bookService.queryAllBooks(page, size);
    }

    @PostMapping
    public BookVo addBook(@RequestBody BookVo bookVo) {
        return bookService.addBook(bookVo);
    }
}
