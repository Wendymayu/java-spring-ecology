package com.wendy.demo.service.impl;

import com.wendy.demo.dao.BookDao;
import com.wendy.demo.dao.BookPo;
import com.wendy.demo.entity.BookVo;
import com.wendy.demo.entity.PageVo;
import com.wendy.demo.service.BookService;
import org.springframework.beans.BeanUtils;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @Description TODO
 * @Author wendyma
 * @Date 2023/12/7 0:12
 * @Version 1.0
 */
@Service
public class BookServiceImpl implements BookService {
    @Resource
    private BookDao bookDao;

    @Override
    public PageVo<BookVo> queryAllBooks(int page, int size) {
        Pageable pageable = PageRequest.of(page, size);
        Page<BookPo> pageData = bookDao.queryAllBooks(pageable);
        List<BookVo> bookVoList = pageData.getContent().stream()
                .map(po -> {
                    BookVo bookVo = new BookVo();
                    BeanUtils.copyProperties(po, bookVo);
                    return bookVo;
                }).collect(Collectors.toList());

        return new PageVo<>(pageData.getTotalElements(), bookVoList);
    }

    @Override
    public BookVo addBook(BookVo bookVo) {
        BookPo bookPo = new BookPo();
        BeanUtils.copyProperties(bookVo, bookPo);
        bookPo.setId(System.currentTimeMillis());
        bookDao.save(bookPo);
        bookVo.setId(bookPo.getId());
        return bookVo;
    }
}
