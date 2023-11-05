package com.wendy.service;

import com.wendy.dao.po.BookPo;
import com.wendy.entity.vo.PageVo;

/**
 * @Description TODO
 * @Author wendyma
 * @Date 2023/9/10 17:21
 * @Version 1.0
 */
public interface BookService {
    PageVo<BookPo> queryAllBooks(int offset, int limit);

    BookPo queryBook(long bookId);

    BookPo addBook(BookPo bookPo);

    BookPo updateBook(BookPo bookPo);

    String deleteBook(long bookId);
}