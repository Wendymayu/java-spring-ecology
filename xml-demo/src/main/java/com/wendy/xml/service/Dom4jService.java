package com.wendy.xml.service;

import com.wendy.xml.entity.PomReq;

import java.util.List;

/**
 * @Description TODO
 * @Author wendyma
 * @Date 2023/10/1 5:31
 * @Version 1.0
 */
public interface Dom4jService {
    /**
     * 根据用户选择的父项目、依赖生成pom.xml
     *
     * @param pomReq 生成pom.xml时用户指定的信息
     * @return
     */
    String generatePom(PomReq pomReq);

    /**
     * 获取生成的pom中的第三方依赖软件信息，格式：groupId:artifactId:version
     *
     * @return 依赖软件信息
     */
    List<String> getDependencies();
}
