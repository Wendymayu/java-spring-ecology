package com.wendy.demo.entity;


import lombok.Getter;
import lombok.Setter;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.User;

import java.util.Collection;

/**
 * @Description 系统用户
 * @Author wendyma
 * @Date 2023/12/6 23:54
 * @Version 1.0
 */
@Getter
@Setter
public class CustomUser extends User {
    private SysUser sysUser;

    public CustomUser(SysUser sysUser, Collection<? extends GrantedAuthority> authorities) {
        super(sysUser.getUserName(), sysUser.getPassword(), authorities);
        this.sysUser = sysUser;
    }
}
