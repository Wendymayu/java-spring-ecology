package com.wendy.file.dao;

import com.wendy.file.dao.po.FilePo;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

/**
 * @Description TODO
 * @Author wendyma
 * @Date 2023/9/29 17:08
 * @Version 1.0
 */
@Repository
public interface FileDao extends CrudRepository<FilePo, Long> {
}