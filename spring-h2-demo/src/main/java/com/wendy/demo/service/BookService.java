package com.wendy.demo.service;

import com.wendy.demo.entity.BookVo;

/**
 * @Description TODO
 * @Author wendyma
 * @Date 2023/12/1 0:01
 * @Version 1.0
 */
public interface BookService {
    BookVo queryBook(long bookId);

    BookVo addBook(BookVo bookVo);
}