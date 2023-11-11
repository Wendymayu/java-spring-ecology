package com.wendy.jdbc.controller;

import com.wendy.jdbc.pojo.BookVo;
import com.wendy.jdbc.service.BookService;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

/**
 * @Description TODO
 * @Author wendyma
 * @Date 2022/7/10 11:33
 * @Version 1.0
 */
@RestController
@RequestMapping("/jdbc-demo/v1/books")
public class BookController {
    @Resource
    private BookService bookService;

    @GetMapping
    public Iterable<BookVo> queryBooks() {
        return bookService.queryBooks();
    }

    @GetMapping("/{id}")
    public BookVo queryBook(@PathVariable("id") long id) {
        return bookService.queryBook(id);
    }

    @PostMapping
    public BookVo addBook(@RequestBody BookVo bookVo) {
        return bookService.addBook(bookVo);
    }
}
