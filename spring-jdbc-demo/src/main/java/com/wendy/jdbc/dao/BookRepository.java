package com.wendy.jdbc.dao;

import com.wendy.jdbc.dao.po.BookPo;

/**
 * @Description TODO
 * @Author wendyma
 * @Date 2022/7/10 12:24
 * @Version 1.0
 */
public interface BookRepository {
    Iterable<BookPo> queryBooks();

    BookPo queryBook(long id);

    void save(BookPo bookPo);
}
