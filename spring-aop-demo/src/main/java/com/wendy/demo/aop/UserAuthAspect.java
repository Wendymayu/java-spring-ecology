package com.wendy.demo.aop;

import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

/**
 * @Description 某些接口需检查用户token是否有效
 * @Author wendyma
 * @Date 2023/11/8 23:32
 * @Version 1.0
 */
@Slf4j
@Component
@Aspect
public class UserAuthAspect {
    @Pointcut("@within(com.wendy.demo.aop.UserAuth)")
    public void checkClass() {
    }

    @Pointcut("@annotation(com.wendy.demo.aop.UserAuth)")
    public void checkMethod() {
    }

    @Before("checkClass()")
    public void beforeClass(JoinPoint joinPoint) {
        checkUserToken();
    }

    @Before("checkMethod()")
    public void beforeMethod(JoinPoint joinPoint) {
        checkUserToken();
    }

    private void checkUserToken() {
        log.info("Check user token success.");
    }

}
