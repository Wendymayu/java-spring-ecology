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
 * @Date 2023/11/22 23:21
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
}
