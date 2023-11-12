package com.wendy.jpa.service;

import com.wendy.jpa.entity.ClassifyVo;

import java.util.List;

/**
 * @Description TODO
 * @Author wendyma
 * @Date 2023/11/11 15:52
 * @Version 1.0
 */
public interface ClassifyService {
    List<ClassifyVo> queryAllClassifys();

    String postClassify(String classifyName);
}
