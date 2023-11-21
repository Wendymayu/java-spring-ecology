package com.wendy.redis.utils;

import lombok.extern.slf4j.Slf4j;
import org.springframework.data.redis.core.*;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import java.util.Collection;
import java.util.List;
import java.util.Objects;
import java.util.concurrent.TimeUnit;

/**
 * @Description Redis工具类
 * @Author wendyma
 * @Date 2023/11/18 23:55
 * @Version 1.0
 */
@Slf4j
@Component
public class RedisUtils {
    @Resource
    private RedisTemplate<String, String> redisTemplate;

    /**
     * String写入缓存
     *
     * @param key   键
     * @param value 值
     */
    public void set(String key, String value) {
        try {
            ValueOperations<String, String> operations = redisTemplate.opsForValue();
            operations.set(key, value);
        } catch (Exception e) {
            log.error("Failed reason is {}", e.getMessage(), e);
        }
    }

    /**
     * String指定过期时间写入缓存
     *
     * @param key        键
     * @param value      值
     * @param expireTime 过期时间
     */
    public void set(String key, String value, long expireTime) {
        try {
            ValueOperations<String, String> operations = redisTemplate.opsForValue();
            operations.set(key, value, expireTime, TimeUnit.SECONDS);
        } catch (Exception e) {
            log.error("Failed reason is {}", e.getMessage(), e);
        }
    }

    /**
     * 设置key的过期时间
     *
     * @param key        键
     * @param expireTime 过期时间
     */
    public void setExpireTime(String key, long expireTime) {
        try {
            if (expireTime > 0) {
                redisTemplate.expire(key, expireTime, TimeUnit.SECONDS);
            }
        } catch (Exception e) {
            log.error("Failed reason is {}", e.getMessage(), e);
        }
    }

    /**
     * 判断键是否存在
     *
     * @param key 键
     * @return
     */
    public boolean exists(String key) {
        return redisTemplate.hasKey(key);
    }

    /**
     * 删除键
     *
     * @param key 键
     */
    public void remove(String key) {
        if (exists(key)) {
            redisTemplate.delete(key);
        }
    }

    /**
     * 批量删除键
     *
     * @param keys 待批量删除的键
     */
    public void batchRemove(List<String> keys) {
        for (String key : keys) {
            remove(key);
        }
    }

    /**
     * 获取值
     *
     * @param key 键
     * @return
     */
    public String get(String key) {
        ValueOperations<String, String> operations = redisTemplate.opsForValue();
        return operations.get(key);
    }

    /**
     * 批量获取值
     *
     * @param keys 键集
     * @return
     */
    public List<String> multiGet(Collection<String> keys) {
        ValueOperations<String, String> operations = redisTemplate.opsForValue();
        return operations.multiGet(keys);
    }

    /**
     * List-RPUSH
     *
     * @param key     键名
     * @param element 元素
     */
    public void rPush(String key, String element) {
        ListOperations<String, String> listOperations = redisTemplate.opsForList();
        listOperations.rightPush(key, element);
    }

    /**
     * List-LPOP
     *
     * @param key 键名
     * @return
     */
    public String lPop(String key) {
        ListOperations<String, String> listOperations = redisTemplate.opsForList();
        return listOperations.leftPop(key);
    }

    /**
     * List长度
     *
     * @param key 键名
     * @return
     */
    public long listSize(String key) {
        if (!exists(key)) {
            return 0;
        }
        ListOperations<String, String> listOperations = redisTemplate.opsForList();
        Long size = listOperations.size(key);
        return Objects.isNull(size) ? 0 : size;
    }

    /**
     * HASH添加元素
     *
     * @param hashKey 哈希表名
     * @param subKey  元素键名
     * @param value   元素值
     */
    public void hashSet(String hashKey, Object subKey, Object value) {
        HashOperations<String, Object, Object> hashOperations = redisTemplate.opsForHash();
        hashOperations.put(hashKey, subKey, value);
    }

    /**
     * HASH获取元素
     *
     * @param hashKey 哈希表名
     * @param subKey  元素键名
     * @return
     */
    public Object hashGet(String hashKey, Object subKey) {
        HashOperations<String, Object, Object> hashOperations = redisTemplate.opsForHash();
        return hashOperations.get(hashKey, subKey);
    }

    /**
     * HASH删除元素
     *
     * @param hashkey 哈希表名
     * @param subKey  元素键名
     */
    public void hashDelete(String hashkey, Object subKey) {
        HashOperations<String, Object, Object> hashOperations = redisTemplate.opsForHash();
        hashOperations.delete(hashkey, subKey);
    }

    /**
     * SET 添加元素
     *
     * @param key     集合名
     * @param element 元素
     */
    public void sAdd(String key, String element) {
        SetOperations<String, String> setOperations = redisTemplate.opsForSet();
        setOperations.add(key, element);
    }

    /**
     * SET 删除一个或多个元素
     *
     * @param key      集合名
     * @param elements 元素
     * @return
     */
    public void sRemove(String key, Collection<String> elements) {
        SetOperations<String, String> setOperations = redisTemplate.opsForSet();
        for (String element : elements) {
            setOperations.remove(key, element);
        }
    }

    /**
     * SET 随机弹出元素
     *
     * @param key 集合名
     * @return
     */
    public String sPop(String key) {
        SetOperations<String, String> setOperations = redisTemplate.opsForSet();
        return setOperations.pop(key);
    }

    /**
     * 元素是否存在于SET
     *
     * @param key     集合名
     * @param element 元素
     * @return
     */
    public boolean sIsMember(String key, String element) {
        SetOperations<String, String> setOperations = redisTemplate.opsForSet();
        return setOperations.isMember(key, element);
    }

    /**
     * SET 元素数量
     *
     * @param key 集合名
     * @return
     */
    public long getSetSize(String key) {
        SetOperations<String, String> setOperations = redisTemplate.opsForSet();
        Long size = setOperations.size(key);
        return Objects.isNull(size) ? 0 : size;
    }

    /**
     * 添加元素到ZSET
     *
     * @param key     有序集合名
     * @param element 元素
     * @param score   分值
     */
    public void zAdd(String key, String element, double score) {
        ZSetOperations<String, String> zSetOperations = redisTemplate.opsForZSet();
        zSetOperations.add(key, element, score);
    }

    /**
     * 移除元素
     *
     * @param key      有序集合名
     * @param elements 待移除元素
     */
    public void zRemove(String key, Collection<String> elements) {
        ZSetOperations<String, String> zSetOperations = redisTemplate.opsForZSet();
        for (String element : elements) {
            zSetOperations.remove(key, element);
        }
    }

    /**
     * 有序集合元素数量
     *
     * @param key 有序集合名
     * @return
     */
    public long zsetSize(String key) {
        ZSetOperations<String, String> zSetOperations = redisTemplate.opsForZSet();
        Long size = zSetOperations.size(key);
        return Objects.isNull(size) ? 0 : size;
    }
}
