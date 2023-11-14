package com.wendy.demo.filter;

import com.wendy.demo.AuditLog;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
import org.springframework.http.HttpMethod;
import org.springframework.web.context.WebApplicationContext;

import javax.annotation.Resource;
import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;

/**
 * @Description 记录接口的审计日志
 * @Author wendyma
 * @Date 2023/11/14 22:42
 * @Version 1.0
 */
@Slf4j
@WebFilter(urlPatterns = "/*", filterName = "auditLogFilter")
public class AuditLogFilter implements Filter {
    @Resource
    private WebApplicationContext applicationContext;

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        System.out.println("AuditLogFilter init.");
    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        HttpServletRequest request = (HttpServletRequest) servletRequest;
        String method = request.getMethod();
        if (StringUtils.equals(method, HttpMethod.GET.name())
                || StringUtils.equals(method, HttpMethod.POST.name())
                || StringUtils.equals(method, HttpMethod.PUT.name())
                || StringUtils.equals(method, HttpMethod.DELETE.name())) {
            String url = request.getRequestURL().toString();
            String userName = request.getHeader("userName");
            AuditLog auditLog = new AuditLog();
            auditLog.setUserName(userName);
            auditLog.setUrl(url);
            log.info(auditLog.toString());
        }
        filterChain.doFilter(servletRequest, servletResponse);
    }

    @Override
    public void destroy() {
        System.out.println("AuditLogFilter destroy.");
    }
}
