package com.wendy.demo.service.impl;

import com.wendy.demo.exception.ErrorCode;
import com.wendy.demo.exception.HelloException;
import com.wendy.demo.service.HelloService;
import org.springframework.stereotype.Service;

/**
 * @Description TODO
 * @Author wendyma
 * @Date 2023/11/13 22:35
 * @Version 1.0
 */
@Service
public class HelloServiceImpl implements HelloService {
    @Override
    public String hello(String name) {
        if (name.length() > 10) {
            throw new HelloException(ErrorCode.NAME_TOO_LONG);
        }
        return "hello" + name;
    }
}
