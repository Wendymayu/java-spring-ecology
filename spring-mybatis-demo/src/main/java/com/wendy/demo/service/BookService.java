package com.wendy.demo.service;

import com.wendy.demo.entity.BookVo;
import com.wendy.demo.entity.PageVo;

/**
 * @Description TODO
 * @Author wendyma
 * @Date 2023/12/3 0:01
 * @Version 1.0
 */
public interface BookService {
    PageVo<BookVo> queryAllBooks(int page, int size);

    BookVo queryBook(long bookId);

    BookVo addBook(BookVo bookVo);

    BookVo updateBook(long bookId, BookVo bookVo);

    void deleteBook(long bookId);
}