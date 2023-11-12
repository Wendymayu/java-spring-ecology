package com.wendy.jpa.service.impl;

import com.wendy.jpa.dao.ClassifyDao;
import com.wendy.jpa.dao.po.ClassifyPo;
import com.wendy.jpa.entity.ClassifyVo;
import com.wendy.jpa.service.ClassifyService;
import org.springframework.beans.BeanUtils;
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
public class ClassifyServiceImpl implements ClassifyService {
    @Resource
    private ClassifyDao classifyDao;

    @Override
    public List<ClassifyVo> queryAllClassifys() {
        List<ClassifyPo> classifyPoList = classifyDao.queryAllClassifys();
        return classifyPoList.stream().map(po -> {
            ClassifyVo vo = new ClassifyVo();
            BeanUtils.copyProperties(po, vo);
            return vo;
        }).collect(Collectors.toList());
    }

    @Override
    public String postClassify(String classifyName) {
        ClassifyPo po = new ClassifyPo();
        po.setClassifyName(classifyName);
        classifyDao.save(po);
        return po.getClassifyName();
    }
}
