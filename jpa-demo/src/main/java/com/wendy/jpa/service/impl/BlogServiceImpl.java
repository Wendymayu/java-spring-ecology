package com.wendy.jpa.service.impl;

import com.wendy.common.exception.CommonException;
import com.wendy.common.exception.ErrorCode;
import com.wendy.jpa.dao.BlogDao;
import com.wendy.jpa.dao.ClassifyDao;
import com.wendy.jpa.dao.TagDao;
import com.wendy.jpa.dao.po.BlogPo;
import com.wendy.jpa.entity.BlogPage;
import com.wendy.jpa.entity.BlogReq;
import com.wendy.jpa.entity.BlogVo;
import com.wendy.jpa.service.BlogService;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.Optional;

/**
 * @Description TODO
 * @Author wendyma
 * @Date 2023/11/11 16:03
 * @Version 1.0
 */
@Service
public class BlogServiceImpl implements BlogService {
    @Resource
    private BlogDao blogDao;

    @Resource
    private TagDao tagDao;

    @Resource
    private ClassifyDao classifyDao;

    @Override
    public BlogPage queryBlogs(int offset, int limit) {
        return null;
    }

    @Override
    public BlogVo postBlog(BlogReq blogReq) {
        BlogPo blogPo = new BlogPo();
        BeanUtils.copyProperties(blogReq, blogPo);
        blogDao.save(blogPo);
        BlogVo blogVo = new BlogVo();
        blogVo.setId(blogPo.getId());
        return blogVo;
    }

    @Override
    public BlogVo queryBlog(long id) {
        Optional<BlogPo> optional = blogDao.findById(id);
        BlogVo blogVo = new BlogVo();
        if (optional.isEmpty()) {
            throw new CommonException(ErrorCode.RESOURCE_NOT_FOUND, "resource not found.");
        }
        BeanUtils.copyProperties(optional.get(), blogVo);
        return blogVo;
    }

    @Override
    public void deleteBlog(long id) {
        blogDao.deleteById(id);
    }

    @Override
    public BlogVo updateBlog(BlogReq blogReq) {
        return null;
    }
}
