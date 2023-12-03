package com.wendy.demo.dao;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @Description TODO
 * @Author wendyma
 * @Date 2023/12/3 0:01
 * @Version 1.0
 */
@Mapper
public interface BookDao {
    int addBook(@Param("bookPo") BookPo bookPo);

    BookPo queryBook(@Param("id") long id);

    int isExist(@Param("id") long id);

    void updateBook(@Param("bookPo") BookPo bookPo);

    void deleteById(@Param("id") long id);

    int count();

    List<BookPo> queryPage(@Param("offset") int offset, @Param("limit") int limit);

    List<BookPo> queryAllBooks();
}