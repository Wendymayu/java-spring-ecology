package com.wendy.jpa.dao;

import com.wendy.jpa.dao.po.TagPo;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

/**
 * @Description TODO
 * @Author wendyma
 * @Date 2023/11/11 16:04
 * @Version 1.0
 */
@Repository
public interface TagDao extends CrudRepository<TagPo, Long> {
    @Query(value = "select po from TagPo as po")
    Page<TagPo> queryAllTags(Pageable pageable);
}