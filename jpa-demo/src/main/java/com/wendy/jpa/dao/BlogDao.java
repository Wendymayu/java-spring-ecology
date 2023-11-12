package com.wendy.jpa.dao;

import com.wendy.jpa.dao.po.BlogPo;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

/**
 * @Description TODO
 * @Author wendyma
 * @Date 2023/11/11 16:03
 * @Version 1.0
 */
@Repository
public interface BlogDao extends CrudRepository<BlogPo, Long> {
}
