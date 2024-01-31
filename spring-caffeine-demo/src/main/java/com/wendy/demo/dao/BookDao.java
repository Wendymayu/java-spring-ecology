package com.wendy.demo.dao;

import com.wendy.demo.dao.po.BookPo;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @Description TODO
 * @Author wendyma
 * @Date 2024/1/30 22:38
 * @Version 1.0
 */
@Repository
public interface BookDao extends CrudRepository<BookPo, Long> {
    @Query(value = "select po from BookPo as po")
    List<BookPo> queryAllBooks();
}