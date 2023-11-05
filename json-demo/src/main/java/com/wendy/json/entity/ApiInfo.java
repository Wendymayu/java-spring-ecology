package com.wendy.json.entity;

import lombok.Data;

import java.util.List;

/**
 * @Description TODO
 * @Author wendyma
 * @Date 2023/10/8 20:43
 * @Version 1.0
 */
@Data
public class ApiInfo {
    private String operationId;

    private String summary;

    private String description;

    private List<String> produces;

    private List<String> consumes;

    private List<String> parameters;

    private Object responses;
}
