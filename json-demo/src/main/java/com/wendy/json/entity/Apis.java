package com.wendy.json.entity;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Data;

/**
 * @Description TODO
 * @Author wendyma
 * @Date 2023/10/8 20:39
 * @Version 1.0
 */
@Data
public class Apis {
    @JsonInclude(JsonInclude.Include.NON_NULL)
    private ApiInfo get;

    @JsonInclude(JsonInclude.Include.NON_NULL)
    private ApiInfo post;

    @JsonInclude(JsonInclude.Include.NON_NULL)
    private ApiInfo put;

    @JsonInclude(JsonInclude.Include.NON_NULL)
    private ApiInfo delete;

    @JsonInclude(JsonInclude.Include.NON_NULL)
    private ApiInfo head;
}
