package com.wendy.demo.controller;

import com.wendy.demo.entity.BookVo;
import com.wendy.demo.entity.PageVo;
import com.wendy.demo.service.BookService;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

/**
 * @Description TODO
 * @Author wendyma
 * @Date 2023/12/3 0:00
 * @Version 1.0
 */
@RestController
@RequestMapping(value = "/mybatis-demo/v1/books")
public class BookController {
    @Resource
    private BookService bookService;

    @GetMapping
    public PageVo<BookVo> queryAllBooks(@RequestParam("page") int page,
                                        @RequestParam("size") int size) {
        return bookService.queryAllBooks(page, size);
    }

    @GetMapping("/{id}")
    public BookVo queryBook(@PathVariable("id") long bookId) {
        return bookService.queryBook(bookId);
    }

    @PostMapping
    public BookVo addBook(@RequestBody BookVo bookVo) {
        return bookService.addBook(bookVo);
    }

    @PutMapping("/{id}")
    public BookVo updateBook(@PathVariable("id") long bookId, @RequestBody BookVo bookVo) {
        return bookService.updateBook(bookId, bookVo);
    }

    @DeleteMapping("/{id}")
    public String deleteBook(@PathVariable("id") long bookId) {
        bookService.deleteBook(bookId);
        return HttpStatus.OK.getReasonPhrase();
    }

}
