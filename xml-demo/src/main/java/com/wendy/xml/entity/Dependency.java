package com.wendy.xml.entity;

import lombok.Data;

/**
 * @Description TODO
 * @Author wendyma
 * @Date 2023/10/1 15:58
 * @Version 1.0
 */
@Data
public class Dependency {
    private String groupId;

    private String artifactId;

    private String version;
}
