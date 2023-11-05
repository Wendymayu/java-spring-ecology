package com.wendy.client.webclient;

import com.wendy.entity.BookPo;

import java.util.List;

/**
 * @Description TODO
 * @Author wendyma
 * @Date 2023/9/17 14:14
 * @Version 1.0
 */
public interface RestServerWebClient {
    List<BookPo> queryAllBooks(int offset, int limit);

    BookPo queryBook(long bookId);

    BookPo addBook(BookPo bookPo);

    BookPo updateBook(BookPo bookPo);

    void deleteBook(long bookId);

    String headerRequest();

    String commonRequest(long id, String key, BookPo bookPo);
}