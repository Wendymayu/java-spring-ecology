package com.wendy.json.entity;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

/**
 * @Description TODO
 * @Author wendyma
 * @Date 2023/10/8 20:26
 * @Version 1.0
 */
@Data
public class SwaggerInfo {
    private String version;

    private String title;

    private String description;

    @JsonProperty("x-hw-deploy-url")
    private String deployUrl;
}
