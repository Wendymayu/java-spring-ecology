package com.wendy.demo.service;

import com.wendy.demo.entity.BookVo;
import com.wendy.demo.entity.PageVo;

/**
 * @Description TODO
 * @Author wendyma
 * @Date 2023/11/22 23:19
 * @Version 1.0
 */
public interface BookService {
    PageVo<BookVo> queryAllBooks(int offset, int limit);
}