package com.wendy.demo.service.impl;

import com.wendy.demo.dao.SysUserDao;
import com.wendy.demo.dao.SysUserPo;
import com.wendy.demo.entity.CustomUser;
import com.wendy.demo.entity.SysUser;
import com.wendy.demo.service.UserService;
import com.wendy.demo.utils.JwtUtils;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.BeanUtils;
import org.springframework.http.HttpStatus;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.Objects;
import java.util.Optional;

/**
 * @Description TODO
 * @Author wendyma
 * @Date 2023/12/7 0:05
 * @Version 1.0
 */
@Slf4j
@Service
public class UserServiceImpl implements UserService {
    @Resource
    private SysUserDao sysUserDao;

    @Resource
    private PasswordEncoder passwordEncoder;

    @Resource
    private UserDetailsService userDetailsService;

    /**
     * 通过AuthenticationManager的authenticate方法来进行用户认证,
     */
    @Resource
    private AuthenticationManager authenticationManager;

    @Override
    public String register(SysUser sysUser) {
        SysUserPo sysUserPo = sysUserDao.querySysUserPoByUserName(sysUser.getUserName());
        if (Objects.nonNull(sysUserPo)) {
            throw new IllegalArgumentException("userName already exists.");
        }

        //加密密码
        String encodedPassword = passwordEncoder.encode(sysUser.getPassword());
        sysUserPo = new SysUserPo();
        sysUserPo.setUserName(sysUser.getUserName());
        sysUserPo.setPassword(encodedPassword);
        sysUserDao.save(sysUserPo);
        return HttpStatus.OK.getReasonPhrase();
    }

    @Override
    public String login(SysUser sysUser) {
        String username = sysUser.getUserName();
        String password = sysUser.getPassword();
        String token = null;
        // 登录时必然要从数据库取用户信息，实际会从loadUserByUsername()取
        UsernamePasswordAuthenticationToken authenticationToken = new UsernamePasswordAuthenticationToken(username, password);
        // authenticate方法会调用loadUserByUsername，校验用户名密码
        Authentication authentication = authenticationManager.authenticate(authenticationToken);

        // 校验成功，获取用户信息
        CustomUser customUser = (CustomUser) authentication.getPrincipal();
        SysUser userInfo = customUser.getSysUser();

        // 生成token
        return JwtUtils.generateToken(userInfo);
    }

    @Override
    public Optional<SysUser> queryUserByUserName(String userName) {
        SysUserPo sysUserPo = sysUserDao.querySysUserPoByUserName(userName);
        if (Objects.isNull(sysUserPo)) {
            return Optional.empty();
        }
        SysUser sysUser = new SysUser();
        BeanUtils.copyProperties(sysUserPo, sysUser);
        return Optional.of(sysUser);
    }

}
