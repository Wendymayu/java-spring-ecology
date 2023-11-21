package com.wendy.redis.service.impl;

import com.wendy.common.utils.JsonUtils;
import com.wendy.redis.entity.BlogVo;
import com.wendy.redis.entity.VoList;
import com.wendy.redis.service.BlogService;
import com.wendy.redis.utils.RedisUtils;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.Date;
import java.util.UUID;

/**
 * @Description 所有数据都保存在redis中
 * @Author wendyma
 * @Date 2023/11/18 23:56
 * @Version 1.0
 */
@Service
public class BlogServiceImpl implements BlogService {
    @Resource
    private RedisUtils redisUtils;

    @Override
    public VoList<BlogVo> queryBlogs(int offset, int linit) {
        return null;
    }

    @Override
    public BlogVo addBlog(BlogVo blogVo) {
        String id = UUID.randomUUID().toString().replaceAll("-", "");
        blogVo.setId(id);
        blogVo.setCreatedTime(new Date());
        blogVo.setUpdatedTime(new Date());
        String content = JsonUtils.toJson(blogVo);
        redisUtils.set(blogVo.getId(), content);
        return blogVo;
    }

    @Override
    public BlogVo queryBlog(String id) {
        if (!redisUtils.exists(id)) {
            throw new IllegalArgumentException("Blog does not exist.");
        }
        String content = redisUtils.get(id);
        return JsonUtils.json2Object(content, BlogVo.class);
    }

    @Override
    public BlogVo updateBlog(String id, BlogVo blogVo) {
        if (!redisUtils.exists(id)) {
            throw new IllegalArgumentException("Blog does not exist.");
        }
        blogVo.setUpdatedTime(new Date());
        String content = JsonUtils.toJson(blogVo);
        redisUtils.set(blogVo.getId(), content);
        return blogVo;
    }

    @Override
    public void deleteBlog(String id) {
        redisUtils.remove(id);
    }
}
