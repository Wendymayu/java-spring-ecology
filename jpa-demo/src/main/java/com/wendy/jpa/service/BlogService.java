package com.wendy.jpa.service;

import com.wendy.jpa.entity.BlogPage;
import com.wendy.jpa.entity.BlogReq;
import com.wendy.jpa.entity.BlogVo;

/**
 * @Description TODO
 * @Author wendyma
 * @Date 2023/11/11 15:51
 * @Version 1.0
 */
public interface BlogService {
    BlogPage queryBlogs(int offset, int limit);

    BlogVo postBlog(BlogReq blogReq);

    BlogVo queryBlog(long id);

    void deleteBlog(long id);

    BlogVo updateBlog(BlogReq blogReq);
}
