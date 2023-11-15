package com.wendy.demo.config;

import com.wendy.demo.interceptor.AuditLogInterceptor;
import com.wendy.demo.interceptor.LoginInterceptor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

/**
 * @Description 注册拦截器
 * @Author wendyma
 * @Date 2023/11/15 22:37
 * @Version 1.0
 */
@Configuration
public class WebMvcConfig implements WebMvcConfigurer {
    @Bean
    public AuditLogInterceptor auditLogInterceptor() {
        return new AuditLogInterceptor();
    }

    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(new LoginInterceptor())
                .addPathPatterns("/**")
                .excludePathPatterns("/login")
                .excludePathPatterns("/register");

        registry.addInterceptor(auditLogInterceptor()).addPathPatterns("/**");
    }
}
