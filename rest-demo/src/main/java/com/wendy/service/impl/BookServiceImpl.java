package com.wendy.service.impl;

import com.wendy.dao.BookDao;
import com.wendy.dao.po.BookPo;
import com.wendy.entity.vo.PageVo;
import com.wendy.service.BookService;
import org.springframework.beans.BeanUtils;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;

/**
 * @Description TODO
 * @Author wendyma
 * @Date 2023/9/10 17:21
 * @Version 1.0
 */
@Service
public class BookServiceImpl implements BookService {
    @Resource
    private BookDao bookDao;

    @Override
    public PageVo<BookPo> queryAllBooks(int offset, int limit) {
        Pageable page = PageRequest.of(offset, limit);
        Page<BookPo> pageData = bookDao.findAllBooks(page);
        return new PageVo<>(pageData.getTotalElements(), pageData.getContent());
    }

    @Override
    public BookPo queryBook(long bookId) {
        return bookDao.findById(bookId).get();
    }

    @Override
    @Transactional
    public BookPo addBook(BookPo bookPo) {
        BeanUtils.copyProperties(bookPo, bookPo);
        bookDao.save(bookPo);
        return bookPo;
    }

    @Override
    public BookPo updateBook(BookPo bookPo) {
        bookDao.save(bookPo);
        return bookPo;
    }

    @Override
    public String deleteBook(long bookId) {
        bookDao.deleteById(bookId);
        return "delete book success";
    }
}
