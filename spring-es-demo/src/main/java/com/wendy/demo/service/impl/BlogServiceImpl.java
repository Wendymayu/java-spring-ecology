package com.wendy.demo.service.impl;

import com.wendy.demo.dao.BlogDao;
import com.wendy.demo.dao.BlogPo;
import com.wendy.demo.entity.BlogVo;
import com.wendy.demo.entity.VoList;
import com.wendy.demo.es.BlogDoc;
import com.wendy.demo.es.BlogRepository;
import com.wendy.demo.service.BlogService;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.Date;

/**
 * @Description TODO
 * @Author wendyma
 * @Date 2023/11/23 23:22
 * @Version 1.0
 */
@Service
public class BlogServiceImpl implements BlogService {
    @Resource
    private BlogDao blogDao;

    @Resource
    private BlogRepository blogRepository;

    @Override
    public VoList<BlogVo> queryBlogs(int offset, int linit) {
        return null;
    }

    @Override
    public BlogVo addBlog(BlogVo blogVo) {
        blogVo.setCreatedTime(new Date());
        blogVo.setUpdatedTime(new Date());
        // 文章持久化到数据库
        BlogPo blogPo = new BlogPo();
        BeanUtils.copyProperties(blogVo, blogPo);
        blogDao.save(blogPo);

        // 文章持久化到es
        BlogDoc blogDoc = new BlogDoc();
        BeanUtils.copyProperties(blogPo, blogDoc);
        blogRepository.save(blogDoc);

        blogVo.setId(blogPo.getId());
        return blogVo;
    }
}
