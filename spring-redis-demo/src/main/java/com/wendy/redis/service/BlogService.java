package com.wendy.redis.service;

import com.wendy.redis.entity.BlogVo;
import com.wendy.redis.entity.VoList;

/**
 * @Description TODO
 * @Author wendyma
 * @Date 2023/11/18 23:50
 * @Version 1.0
 */
public interface BlogService {
    VoList<BlogVo> queryBlogs(int offset, int linit);

    BlogVo addBlog(BlogVo blogVo);

    BlogVo queryBlog(String id);

    BlogVo updateBlog(String id, BlogVo blogVo);

    void deleteBlog(String id);
}