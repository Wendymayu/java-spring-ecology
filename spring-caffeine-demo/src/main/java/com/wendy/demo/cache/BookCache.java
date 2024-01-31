package com.wendy.demo.cache;

import com.github.benmanes.caffeine.cache.Cache;
import com.github.benmanes.caffeine.cache.Caffeine;
import com.wendy.demo.dao.BookDao;
import com.wendy.demo.entity.BookVo;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import java.util.List;
import java.util.concurrent.TimeUnit;

/**
 * @Description 书籍缓存工具类
 * @Author wendyma
 * @Date 2024/1/30 22:33
 * @Version 1.0
 */
@Component
public class BookCache {
    @Resource
    private BookDao bookDao;

    private static final Cache<String, Object> caffeineCache = Caffeine.newBuilder()
            .expireAfterWrite(600, TimeUnit.SECONDS)
            .initialCapacity(100)
            .maximumSize(1000)
            .build();

    @SuppressWarnings("unchecked")
    public List<BookVo> queryAllBooks() {
        String cacheKey = "queryAllBooks";
        return (List<BookVo>) caffeineCache.get(cacheKey, key -> bookDao.queryAllBooks());
    }
}
