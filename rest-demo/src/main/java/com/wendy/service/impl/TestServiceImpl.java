package com.wendy.service.impl;

import com.wendy.service.TestService;
import org.springframework.stereotype.Service;

/**
 * @Description TODO
 * @Author wendyma
 * @Date 2023/9/17 12:29
 * @Version 1.0
 */
@Service
public class TestServiceImpl implements TestService {
    @Override
    public String checkAuthorization(String authorization) {
        // TODO
        System.out.println("the authorization is: "+authorization);
        return "success";
    }
}
