package com.wendy.demo.dao;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

/**
 * @Description TODO
 * @Author wendyma
 * @Date 2023/11/23 23:33
 * @Version 1.0
 */
@Repository
public interface BlogDao extends CrudRepository<BlogPo, Long> {
}