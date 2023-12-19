package com.wendy.controller;

import com.wendy.entity.BookVo;
import com.wendy.grpc.BookServiceClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * @Description TODO
 * @Author wendyma
 * @Date 2023/10/22 17:14
 * @Version 1.0
 */
@RestController
@RequestMapping(value = "/grpc-client/v1/books")
public class BookController {
    @Resource
    private BookServiceClient bookServiceClient;

    @GetMapping("/{id}")
    public BookVo queryBook(@PathVariable("id") long bookId) {
        return bookServiceClient.queryBook(bookId);
    }

/*    @PostMapping
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
    }*/
}
