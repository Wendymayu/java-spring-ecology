package com.wendy.demo.service.impl;

import com.wendy.demo.dao.BookDao;
import com.wendy.demo.dao.po.BookPo;
import com.wendy.demo.entity.BookVo;
import com.wendy.demo.entity.VoList;
import com.wendy.demo.service.BookService;
import org.springframework.beans.BeanUtils;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.List;
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
    public VoList<BookVo> queryAllBooks(int offset, int limit) {
        Pageable page = PageRequest.of(offset, limit);
        Page<BookPo> pageData = bookDao.findAllBooks(page);
        List<BookVo> bookVoList = pageData.getContent().stream()
                .map(po -> {
                    BookVo bookVo = new BookVo();
                    BeanUtils.copyProperties(po, bookVo);
                    return bookVo;
                }).collect(Collectors.toList());

        int total = (int) pageData.getTotalElements();
        return new VoList<>(total, bookVoList);
    }

    @Cacheable(value = "bookCache", key = "#bookId")
    @Override
    public BookVo queryBook(long bookId) {
        BookPo bookPo = bookDao.findById(bookId).get();
        BookVo bookVo = new BookVo();
        BeanUtils.copyProperties(bookPo, bookVo);
        return bookVo;
    }

    @CachePut(value = "bookCache", key = "#bookVo.id")
    @Override
    @Transactional
    public BookVo addBook(BookVo bookVo) {
        BookPo bookPo = new BookPo();
        BeanUtils.copyProperties(bookVo, bookPo);
        bookDao.save(bookPo);
        bookVo.setId(bookPo.getId());
        return bookVo;
    }

    @CachePut(value = "bookCache", key = "#bookVo.id")
    @Override
    public BookVo updateBook(BookVo bookVo) {
        BookPo bookPo = new BookPo();
        BeanUtils.copyProperties(bookVo, bookPo);
        bookDao.save(bookPo);
        return bookVo;
    }

    @CacheEvict(cacheNames = "bookCache", key = "#bookId")
    @Override
    public String deleteBook(long bookId) {
        bookDao.deleteById(bookId);
        return "delete book success";
    }
}
