package com.wendy.demo.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
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
 * @Date 2023/12/3 0:02
 * @Version 1.0
 */
@Service
public class BookServiceImpl implements BookService {
    @Resource
    private BookDao bookDao;

    @Override
    public PageVo<BookVo> queryAllBooks(int page, int size) {
        return queryByPageHelper(page, size);
    }

    /**
     * 查询总数，查询list，实现分页
     * @param page 页码
     * @param size 页大小
     * @return
     */
    private PageVo<BookVo> queryPageBookVo(int page, int size) {
        int total = bookDao.count();
        int offset = page * size;
        List<BookPo> bookPoList = bookDao.queryPage(offset, size);
        List<BookVo> bookVoList = bookPoList.stream().map(po -> {
            BookVo vo = new BookVo();
            BeanUtils.copyProperties(po, vo);
            return vo;
        }).collect(Collectors.toList());
        return new PageVo<>(total, bookVoList);
    }

    /**
     * 使用PageHelper插件实现分页
     * @param page 页码
     * @param size 页大小
     * @return
     */
    public PageVo<BookVo> queryByPageHelper(int page, int size) {
        int offset = page * size;
        PageHelper.startPage(offset, size);
        PageInfo<BookPo> pageInfo = new PageInfo<>(bookDao.queryAllBooks());
        long total = pageInfo.getTotal();
        List<BookVo> bookVoList = pageInfo.getList().stream().map(po -> {
            BookVo vo = new BookVo();
            BeanUtils.copyProperties(po, vo);
            return vo;
        }).collect(Collectors.toList());
        return new PageVo<>(total, bookVoList);
    }

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

    @Override
    public BookVo updateBook(long bookId, BookVo bookVo) {
        int num = bookDao.isExist(bookId);
        if (num < 1) {
            throw new IllegalArgumentException("The book to be updated does not exist.");
        }
        BookPo bookPo = new BookPo();
        BeanUtils.copyProperties(bookVo, bookPo);
        bookDao.updateBook(bookPo);
        return bookVo;
    }

    @Override
    public void deleteBook(long bookId) {
        bookDao.deleteById(bookId);
    }
}
