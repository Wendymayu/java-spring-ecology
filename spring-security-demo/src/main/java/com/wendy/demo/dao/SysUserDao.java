package com.wendy.demo.dao;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @Description TODO
 * @Author wendyma
 * @Date 2023/12/8 22:15
 * @Version 1.0
 */
@Repository
public interface SysUserDao extends CrudRepository<SysUserPo, Long> {
    SysUserPo querySysUserPoByUserName(String userName);
}