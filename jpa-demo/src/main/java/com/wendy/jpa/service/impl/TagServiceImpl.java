package com.wendy.jpa.service.impl;

import com.wendy.jpa.dao.TagDao;
import com.wendy.jpa.dao.po.TagPo;
import com.wendy.jpa.entity.PageVo;
import com.wendy.jpa.entity.TagVo;
import com.wendy.jpa.service.TagService;
import org.springframework.beans.BeanUtils;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @Description TODO
 * @Author wendyma
 * @Date 2023/11/12 9:25
 * @Version 1.0
 */
@Service
public class TagServiceImpl implements TagService {
    @Resource
    private TagDao tagDao;

    @Override
    public PageVo<TagVo> queryTags(int offset, int limit) {
        Pageable pageable = PageRequest.of(offset, limit);
        Page<TagPo> pageData = tagDao.queryAllTags(pageable);
        List<TagVo> tagVoList = pageData.getContent().stream().map(po -> {
            TagVo tagVo = new TagVo();
            BeanUtils.copyProperties(po, tagVo);
            return tagVo;
        }).collect(Collectors.toList());
        return new PageVo<>((int) pageData.getTotalElements(), tagVoList);

    }

    @Override
    public String postTag(String tagName) {
        TagPo tagPo = new TagPo();
        tagPo.setTagName(tagName);
        tagDao.save(tagPo);
        return tagPo.getTagName();
    }
}
