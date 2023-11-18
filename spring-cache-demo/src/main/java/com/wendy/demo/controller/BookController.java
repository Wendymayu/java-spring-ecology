package com.wendy.demo.controller;

import com.wendy.demo.entity.BookVo;
import com.wendy.demo.entity.VoList;
import com.wendy.demo.service.BookService;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

/**
 * @Description TODO
 * @Author wendyma
 * @Date 2023/11/18 14:54
 * @Version 1.0
 */
@RestController
@RequestMapping(value = "/cache-demo/v1/books")
public class BookController {
    @Resource
    private BookService bookService;

    @GetMapping
    public VoList<BookVo> queryAllBooks(@RequestParam("offset") int offset,
                                        @RequestParam("limit") int limit) {
        return bookService.queryAllBooks(offset, limit);
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
        return bookService.updateBook(bookVo);
    }

    @DeleteMapping("/{id}")
    public String deleteBook(@PathVariable("id") int bookId) {
        return bookService.deleteBook(bookId);
    }
}
