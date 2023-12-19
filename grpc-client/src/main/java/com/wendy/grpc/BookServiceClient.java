package com.wendy.grpc;

import com.wendy.entity.BookVo;

/**
 * @Description TODO
 * @Author wendyma
 * @Date 2023/11/18 10:16
 * @Version 1.0
 */
public interface BookServiceClient {
    BookVo queryBook(long bookId);
}