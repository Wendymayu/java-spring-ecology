package com.wendy.xml.entity;

import lombok.Data;

import java.util.List;

/**
 * @Description 生成pom.ml所需的信息
 * @Author wendyma
 * @Date 2023/10/1 17:20
 * @Version 1.0
 */
@Data
public class PomReq {
    private Dependency parent;

    private List<Dependency> dependencies;
}
