package com.wendy.demo.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import org.apache.ibatis.annotations.Mapper;

/**
 * @Description TODO
 * @Author wendyma
 * @Date 2023/12/4 0:01
 * @Version 1.0
 */
@Mapper
public interface BookDao extends BaseMapper<BookPo> {
    IPage<BookPo> queryAllBooks(Page<BookPo> page);
}