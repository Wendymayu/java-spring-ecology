package com.wendy.demo.aop;

import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.stereotype.Component;

/**
 * @Description TODO
 * @Author wendyma
 * @Date 2023/11/8 22:18
 * @Version 1.0
 */
@Slf4j
@Component
@Aspect
public class LogAspect {
    @Pointcut("execution(public * com.wendy.demo.controller.*.*(..))")
    public void webLog() {
    }

    @Around("webLog()")
    public Object aroundRequest(ProceedingJoinPoint joinPoint) throws Throwable {
        MethodSignature methodSignature = (MethodSignature) joinPoint.getSignature();
        String className = methodSignature.getDeclaringType().getSimpleName();
        String methodName = methodSignature.getMethod().getName();
        long start = System.currentTimeMillis();

        // 执行目标方法
        Object result = joinPoint.proceed();
        long end = System.currentTimeMillis();
        log.info("{}-{} execution use time {} ms", className, methodName, end - start);
        return result;
    }
}
