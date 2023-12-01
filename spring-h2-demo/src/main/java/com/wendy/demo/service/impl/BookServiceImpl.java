package com.wendy.demo.service.impl;

import com.wendy.demo.dao.BookDao;
import com.wendy.demo.dao.BookPo;
import com.wendy.demo.entity.BookVo;
import com.wendy.demo.service.BookService;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * @Description TODO
 * @Author wendyma
 * @Date 2023/12/1 0:02
 * @Version 1.0
 */
@Service
public class BookServiceImpl implements BookService {
    @Resource
    private BookDao bookDao;

    @Override
    public BookVo queryBook(long bookId) {
        BookPo bookPo = bookDao.queryBook(bookId);
        BookVo bookVo = new BookVo();
        BeanUtils.copyProperties(bookPo, bookVo);
        return bookVo;
    }

    @Override
    public BookVo addBook(BookVo bookVo) {
        BookPo bookPo = new BookPo();
        BeanUtils.copyProperties(bookVo, bookPo);
        bookPo.setId(System.currentTimeMillis());
        bookDao.addBook(bookPo);
        bookVo.setId(bookPo.getId());
        return bookVo;
    }
}
