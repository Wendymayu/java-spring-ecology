package com.wendy.jdbc.service.impl;

import com.wendy.jdbc.dao.BookRepository;
import com.wendy.jdbc.dao.po.BookPo;
import com.wendy.jdbc.pojo.BookVo;
import com.wendy.jdbc.service.BookService;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 * @Description TODO
 * @Author wendyma
 * @Date 2023/11/11 11:08
 * @Version 1.0
 */
@Service
public class BookServiceImpl implements BookService {
    @Resource
    private BookRepository bookRepository;

    public Iterable<BookVo> queryBooks() {
        Iterable<BookPo> iterable = bookRepository.queryBooks();
        List<BookVo> bookVoList = new ArrayList<>();
        Iterator<BookPo> iterator = iterable.iterator();
        while (iterator.hasNext()) {
            BookVo bookVo = new BookVo();
            BeanUtils.copyProperties(iterator.next(), bookVo);
            bookVoList.add(bookVo);
        }
        return bookVoList;
    }

    public BookVo queryBook(long id) {
        BookPo bookPo = bookRepository.queryBook(id);
        BookVo bookVo = new BookVo();
        BeanUtils.copyProperties(bookPo, bookVo);
        return bookVo;
    }

    @Override
    public BookVo addBook(BookVo bookVo) {
        BookPo bookPo = new BookPo();
        BeanUtils.copyProperties(bookVo, bookPo);
        bookRepository.save(bookPo);
        bookVo.setId(bookPo.getId());
        return bookVo;
    }
}
