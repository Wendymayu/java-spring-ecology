package com.wendy.demo.service.impl;

import com.wendy.demo.cache.BookCache;
import com.wendy.demo.entity.BookVo;
import com.wendy.demo.service.BookService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * @Description TODO
 * @Author wendyma
 * @Date 2024/1/30 22:32
 * @Version 1.0
 */
@Service
public class BookServiceImpl implements BookService {
    @Resource
    private BookCache bookCache;

    @Override
    public List<BookVo> queryAllBooks() {
        return bookCache.queryAllBooks();
    }
}
