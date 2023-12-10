package com.wendy.demo.service;

import com.wendy.demo.entity.BookVo;
import com.wendy.demo.entity.PageVo;

/**
 * @Description TODO
 * @Author wendyma
 * @Date 2023/12/7 0:10
 * @Version 1.0
 */
public interface BookService {
    PageVo<BookVo> queryAllBooks(int page, int size);

    BookVo addBook(BookVo bookVo);
}