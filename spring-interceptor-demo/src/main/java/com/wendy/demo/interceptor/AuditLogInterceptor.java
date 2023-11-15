package com.wendy.demo.interceptor;

import org.springframework.lang.Nullable;
import org.springframework.web.method.HandlerMethod;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.lang.reflect.Method;

/**
 * @Description 该过滤器用来计算接口的执行时间
 * @Author wendyma
 * @Date 2023/11/15 22:25
 * @Version 1.0
 */
public class AuditLogInterceptor implements HandlerInterceptor {
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        long startTime = System.currentTimeMillis();
        System.out.println("-------- LogInterception.preHandle --- ");
        request.setAttribute("startTime", startTime);
        return true;
    }

    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, @Nullable ModelAndView modelAndView) throws Exception {
        System.out.println("AuditLogInterceptor postHandle");
    }

    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, @Nullable Exception ex) throws Exception {
        Method method = ((HandlerMethod) handler).getMethod();
        String methodName = method.getName();
        Class<?> beanType = ((HandlerMethod) handler).getBeanType();
        String controllerName = beanType.getSimpleName();

        long startTime = (Long) request.getAttribute("startTime");
        long endTime = System.currentTimeMillis();
        System.out.println(controllerName + "-" + methodName + " Taken time: " + (endTime - startTime));
    }
}
