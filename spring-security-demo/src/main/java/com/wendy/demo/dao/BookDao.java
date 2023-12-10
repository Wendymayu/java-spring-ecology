package com.wendy.demo.dao;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

/**
 * @Description TODO
 * @Author wendyma
 * @Date 2023/12/4 0:01
 * @Version 1.0
 */
@Repository
public interface BookDao extends CrudRepository<BookPo, Long> {
    @Query(value = "select po from BookPo as po")
    Page<BookPo> queryAllBooks(Pageable pageable);
}