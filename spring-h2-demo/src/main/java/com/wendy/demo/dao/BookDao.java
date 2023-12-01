package com.wendy.demo.dao;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

/**
 * @Description TODO
 * @Author wendyma
 * @Date 2023/12/1 0:01
 * @Version 1.0
 */
@Mapper
public interface BookDao {
    int addBook(@Param("bookPo") BookPo bookPo);

    BookPo queryBook(@Param("id") long id);
}