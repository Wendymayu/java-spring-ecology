package com.wendy.jdbc.service;

import com.wendy.jdbc.pojo.BookVo;

/**
 * @Description TODO
 * @Author wendyma
 * @Date 2022/7/10 12:39
 * @Version 1.0
 */
public interface BookService {
    Iterable<BookVo> queryBooks();

    BookVo queryBook(long id);

    BookVo addBook(BookVo bookVo);
}
