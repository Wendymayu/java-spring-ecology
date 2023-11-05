package com.wendy.json.entity;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

/**
 * @Description TODO
 * @Author wendyma
 * @Date 2023/10/8 20:13
 * @Version 1.0
 */
@Data
public class AuthContent {
    @JsonProperty("auth_type")
    private String authType;

    @JsonProperty("auth_info")
    private String authInfo;

    @JsonProperty("auth_config")
    private String authConfig;

    @JsonProperty("auth_prop")
    private String authProp;

    @JsonProperty("auth_dynamic")
    private String authDynamic;

    @JsonProperty("host_config")
    private String hostConfig;

    @JsonProperty("cdm_params_config")
    private String cdmParamsConfig;
}
