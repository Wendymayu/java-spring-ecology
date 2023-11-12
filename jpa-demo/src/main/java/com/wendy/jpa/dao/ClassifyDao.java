package com.wendy.jpa.dao;

import com.wendy.jpa.dao.po.ClassifyPo;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @Description TODO
 * @Author wendyma
 * @Date 2023/11/11 16:04
 * @Version 1.0
 */
@Repository
public interface ClassifyDao extends CrudRepository<ClassifyPo, Long> {
    @Query(value = "select po from ClassifyPo as po")
    List<ClassifyPo> queryAllClassifys();
}
