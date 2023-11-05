package com.wendy.client.resttemplate;

import com.wendy.entity.BookPo;

import java.util.List;

/**
 * @Description TODO
 * @Author wendyma
 * @Date 2023/9/16 23:35
 * @Version 1.0
 */
public interface RestTemplateClient {
    List<BookPo> queryAllBooks(int offset, int limit);

    BookPo queryBook(long bookId);

    BookPo addBook(BookPo bookPo);

    BookPo updateBook(BookPo bookPo);

    void deleteBook(long bookId);

    String headerRequest();

    String commonRequest(long id, BookPo bookPo);
}