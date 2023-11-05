package com.wendy.swagger.service;

import com.wendy.swagger.entity.vo.BookVo;
import com.wendy.swagger.entity.vo.PageVo;

/**
 * @Description TODO
 * @Author wendyma
 * @Date 2023/9/10 17:21
 * @Version 1.0
 */
public interface BookService {
    PageVo<BookVo> queryAllBooks(int offset, int limit);

    BookVo queryBook(long bookId);

    BookVo addBook(BookVo bookVo);

    BookVo updateBook(long bookId, BookVo bookVo);

    String deleteBook(long bookId);
}