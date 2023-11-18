package com.wendy.demo.i18n;

import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.LocaleResolver;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Locale;
import java.util.Objects;

/**
 * @Description 自定义语言解析器
 * @Author wendyma
 * @Date 2023/11/17 22:43
 * @Version 1.0
 */
@Component("localeResolver")
public class CustomLocaleResolver implements LocaleResolver {
    private Locale defaultLocale;

    @Override
    public Locale resolveLocale(HttpServletRequest request) {
        // 默认语言
        if (Objects.nonNull(getDefaultLocale())) {
            return getDefaultLocale();
        }

        // http协议请求头Accept-Language设置的语言
        String acceptLang = request.getHeader("Accept-Language");
        if (Objects.nonNull(acceptLang)) {
            return request.getLocale();
        }

        // 自定义语言
        String lang = request.getHeader("lang");
        if (StringUtils.isNotEmpty(lang)) {
            String[] strings = lang.split("-");
            return new Locale(strings[0], strings[1]);
        }

        // 请求默认的语言
        return request.getLocale();
    }

    @Override
    public void setLocale(HttpServletRequest request, HttpServletResponse response, Locale locale) {

    }

    public void setDefaultLocale(Locale defaultLocale) {
        this.defaultLocale = defaultLocale;
    }

    private Locale getDefaultLocale() {
        return defaultLocale;
    }
}
