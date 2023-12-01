package com.wendy.demo.controller;

import com.wendy.demo.entity.BookVo;
import com.wendy.demo.service.BookService;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

/**
 * @Description TODO
 * @Author wendyma
 * @Date 2023/12/1 0:00
 * @Version 1.0
 */
@RestController
@RequestMapping(value = "/h2-demo/v1/books")
public class BookController {
    @Resource
    private BookService bookService;

    @GetMapping("/{id}")
    public BookVo queryBook(@PathVariable("id") long bookId) {
        return bookService.queryBook(bookId);
    }

    @PostMapping
    public BookVo addBook(@RequestBody BookVo bookVo) {
        return bookService.addBook(bookVo);
    }
}
