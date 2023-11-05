package com.wendy.controller;

import com.wendy.dao.po.BookPo;
import com.wendy.entity.vo.PageVo;
import com.wendy.service.BookService;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

/**
 * @Description TODO
 * @Author wendyma
 * @Date 2023/9/10 17:14
 * @Version 1.0
 */
@RestController
@RequestMapping(value = "/rest-demo/v1/books")
public class BookController {
    @Resource
    private BookService bookService;

    @GetMapping
    public PageVo<BookPo> queryAllBooks(@RequestParam("offset") int offset,
                                        @RequestParam("limit") int limit) {
        return bookService.queryAllBooks(offset, limit);
    }

    @GetMapping("/{id}")
    public BookPo queryBook(@PathVariable("id") long bookId) {
        return bookService.queryBook(bookId);
    }

    @PostMapping
    public BookPo addBook(@RequestBody BookPo bookPo) {
        return bookService.addBook(bookPo);
    }

    @PutMapping("/{id}")
    public BookPo updateBook(@PathVariable("id") long bookId, @RequestBody BookPo bookPo) {
        return bookService.updateBook(bookPo);
    }

    @DeleteMapping("/{id}")
    public String deleteBook(@PathVariable("id") int bookId) {
        return bookService.deleteBook(bookId);
    }
}
