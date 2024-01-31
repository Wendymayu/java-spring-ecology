package com.wendy.demo.service;

import com.wendy.demo.entity.BookVo;

import java.util.List;

/**
 * @Description TODO
 * @Author wendyma
 * @Date 2024/1/30 22:32
 * @Version 1.0
 */
public interface BookService {
    List<BookVo> queryAllBooks();
}