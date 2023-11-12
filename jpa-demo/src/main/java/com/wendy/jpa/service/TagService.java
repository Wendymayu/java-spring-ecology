package com.wendy.jpa.service;

import com.wendy.jpa.entity.PageVo;
import com.wendy.jpa.entity.TagVo;

import java.util.List;

/**
 * @Description TODO
 * @Author wendyma
 * @Date 2023/11/11 15:51
 * @Version 1.0
 */
public interface TagService {
    PageVo<TagVo> queryTags(int offset, int limit);

    String postTag(String tagName);
}
