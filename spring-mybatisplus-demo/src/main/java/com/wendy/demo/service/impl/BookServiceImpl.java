package com.wendy.demo.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.wendy.demo.dao.BookDao;
import com.wendy.demo.dao.BookPo;
import com.wendy.demo.entity.BookVo;
import com.wendy.demo.entity.PageVo;
import com.wendy.demo.service.BookService;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @Description TODO
 * @Author wendyma
 * @Date 2023/12/4 0:02
 * @Version 1.0
 */
@Service
public class BookServiceImpl implements BookService {
    @Resource
    private BookDao bookDao;

    @Override
    public PageVo<BookVo> queryAllBooks(int page, int size) {
        Page<BookPo> poPage = new Page<>(page, size);
        IPage<BookPo> iPage = bookDao.queryAllBooks(poPage);
        long total = iPage.getTotal();
        List<BookVo> bookVoList = iPage.getRecords().stream().map(po -> {
            BookVo vo = new BookVo();
            BeanUtils.copyProperties(po, vo);
            return vo;
        }).collect(Collectors.toList());
        return new PageVo<>(total, bookVoList);
    }

    @Override
    public BookVo queryBook(long bookId) {
        BookPo bookPo = bookDao.selectById(bookId);
        BookVo bookVo = new BookVo();
        BeanUtils.copyProperties(bookPo, bookVo);
        return bookVo;
    }

    @Override
    public BookVo addBook(BookVo bookVo) {
        BookPo bookPo = new BookPo();
        BeanUtils.copyProperties(bookVo, bookPo);
        bookPo.setId(System.currentTimeMillis());
        bookDao.insert(bookPo);
        bookVo.setId(bookPo.getId());
        return bookVo;
    }

    @Override
    public BookVo updateBook(long bookId, BookVo bookVo) {
        LambdaQueryWrapper<BookPo> queryWrapper = new LambdaQueryWrapper<>();
        queryWrapper.eq(BookPo::getId, bookId);
        int num = bookDao.selectCount(queryWrapper);
        if (num < 1) {
            throw new IllegalArgumentException("The book to be updated does not exist.");
        }
        BookPo bookPo = new BookPo();
        BeanUtils.copyProperties(bookVo, bookPo);

        queryWrapper = new LambdaQueryWrapper<>();
        queryWrapper.eq(BookPo::getId, bookId);
        bookDao.update(bookPo, queryWrapper);
        return bookVo;
    }

    @Override
    public void deleteBook(long bookId) {
        bookDao.deleteById(bookId);
    }
}
