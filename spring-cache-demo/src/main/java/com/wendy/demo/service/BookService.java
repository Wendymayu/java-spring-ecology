package com.wendy.demo.service;

import com.wendy.demo.entity.BookVo;
import com.wendy.demo.entity.VoList;

/**
 * @Description TODO
 * @Author wendyma
 * @Date 2023/9/10 17:21
 * @Version 1.0
 */
public interface BookService {
    VoList<BookVo> queryAllBooks(int offset, int limit);

    BookVo queryBook(long bookId);

    BookVo addBook(BookVo bookVo);

    BookVo updateBook(BookVo bookVo);

    String deleteBook(long bookId);
}