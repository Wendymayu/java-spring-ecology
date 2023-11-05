package com.wendy.json.entity;

import lombok.Data;

import java.util.List;
import java.util.Map;

/**
 * @Description TODO
 * @Author wendyma
 * @Date 2023/10/8 20:20
 * @Version 1.0
 */
@Data
public class Swagger {
    private String swagger;

    private SwaggerInfo info;

    private List<String> schemes;

    private String host;

    private String basePath;

    private List<Tag> tags;

    /**
     * key为api的url，value为api的信息
     */
    private Map<String, Apis> paths;
}
