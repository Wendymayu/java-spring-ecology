package com.wendy.demo.utils;

import com.wendy.demo.entity.SysUser;

/**
 * @Description TODO
 * @Author wendyma
 * @Date 2023/12/9 0:04
 * @Version 1.0
 */
public class JwtUtils {
    /**
     * 给用户生成token
     *
     * @param sysUser 用户信息
     * @return
     */
    public static String generateToken(SysUser sysUser) {
        return "token_value";
    }

    /**
     * 从token中解析用户名，实际可用jwt实现
     *
     * @param token token
     * @return
     */
    public static String parseUserNameFromToken(String token) {
        return "wendyma";
    }
}
