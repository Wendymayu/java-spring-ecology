package com.wendy.demo.security;

import com.wendy.demo.entity.CustomUser;
import com.wendy.demo.entity.SysUser;
import com.wendy.demo.service.UserService;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

/**
 * @Description Spring security需要注册该bean
 * @Author wendyma
 * @Date 2023/12/8 22:55
 * @Version 1.0
 */
@Component
public class UserDetailsServiceImpl implements UserDetailsService {
    @Resource
    private UserService userService;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Optional<SysUser> optional = userService.queryUserByUserName(username);
        if (optional.isEmpty()) {
            throw new RuntimeException("user dose not exist, please register.");
        }
        List<SimpleGrantedAuthority> authorities = new ArrayList<>();
        authorities.add(new SimpleGrantedAuthority("demo:book:read2"));
        return new CustomUser(optional.get(), authorities);
    }
}
