package com.wendy.demo.i18n;

import org.springframework.context.MessageSource;
import org.springframework.context.i18n.LocaleContextHolder;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;

/**
 * @Description 国际化工具类
 * @Author wendyma
 * @Date 2023/11/17 23:01
 * @Version 1.0
 */
@Component
public class MessageUtils {
    @Resource
    private MessageSource messageSource;

    public String getMessage(String code){
        return messageSource.getMessage(code, null, LocaleContextHolder.getLocale());
    }
}
