package com.wendy.demo.service;

import com.wendy.demo.entity.BlogVo;
import com.wendy.demo.entity.VoList;

/**
 * @Description TODO
 * @Author wendyma
 * @Date 2023/11/23 23:21
 * @Version 1.0
 */
public interface BlogService {
    VoList<BlogVo> queryBlogs(int offset, int linit);

    BlogVo addBlog(BlogVo blogVo);
}
