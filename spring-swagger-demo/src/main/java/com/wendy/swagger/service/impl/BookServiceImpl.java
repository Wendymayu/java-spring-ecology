package com.wendy.swagger.service.impl;

import com.wendy.swagger.dao.BookDao;
import com.wendy.swagger.dao.po.BookPo;
import com.wendy.swagger.entity.vo.BookVo;
import com.wendy.swagger.entity.vo.PageVo;
import com.wendy.swagger.service.BookService;
import org.springframework.beans.BeanUtils;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

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
    public PageVo<BookVo> queryAllBooks(int offset, int limit) {
        Pageable page = PageRequest.of(offset, limit);
        Page<BookPo> pageData = bookDao.findAllBooks(page);
        List<BookPo> bookPoList = pageData.getContent();
        List<BookVo> bookVoList = bookPoList.stream().map(bookPo -> {
            BookVo bookVo = new BookVo();
            BeanUtils.copyProperties(bookPo, bookVo);
            return bookVo;
        }).collect(Collectors.toList());

        return new PageVo<>(pageData.getTotalElements(), bookVoList);
    }

    @Override
    public BookVo queryBook(long bookId) {
        BookPo bookPo = bookDao.findById(bookId).get();
        BookVo bookVo = new BookVo();
        BeanUtils.copyProperties(bookPo, bookVo);
        return bookVo;
    }

    @Override
    @Transactional
    public BookVo addBook(BookVo bookVo) {
        BookPo bookPo = new BookPo();
        BeanUtils.copyProperties(bookVo, bookPo);
        bookDao.save(bookPo);
        bookVo.setId(bookPo.getId());
        return bookVo;
    }

    @Override
    public BookVo updateBook(long bookId, BookVo bookVo) {
        Optional<BookPo> optional = bookDao.findById(bookId);
        if (optional.isEmpty()) {
            throw new IllegalArgumentException("bookId does not exist");
        }
        BookPo bookPo = new BookPo();
        BeanUtils.copyProperties(bookVo, bookPo);
        bookDao.save(bookPo);
        return bookVo;
    }

    @Override
    public String deleteBook(long bookId) {
        bookDao.deleteById(bookId);
        return "delete book success";
    }
}
