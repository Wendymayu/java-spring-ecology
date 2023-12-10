package com.wendy.demo.service;

import com.wendy.demo.entity.CustomUser;
import com.wendy.demo.entity.SysUser;

import java.util.Optional;

/**
 * @Description TODO
 * @Author wendyma
 * @Date 2023/12/7 0:03
 * @Version 1.0
 */
public interface UserService {
    /**
     * 用户注册
     * @param sysUser
     * @return
     */
    String register(SysUser sysUser);

    /**
     * 登录功能
     *
     * @param sysUser 用户信息
     * @return 生成的JWT的token
     */
    String login(SysUser sysUser);

    /**
     *  查询用户
     * @param userName 用户名
     * @return
     */
    Optional<SysUser> queryUserByUserName(String userName);
}