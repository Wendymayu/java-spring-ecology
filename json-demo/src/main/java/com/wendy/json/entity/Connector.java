package com.wendy.json.entity;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

/**
 * @Description TODO
 * @Author wendyma
 * @Date 2023/10/7 23:39
 * @Version 1.0
 */
@Data
public class Connector {
    @JsonProperty("id")
    private String id;

    @JsonProperty("type")
    private String type;

    @JsonProperty("name")
    private String name;

    @JsonProperty("description")
    private String description;

    @JsonProperty("icon")
    private String icon;

    @JsonProperty("created_time")
    private String createdTime;

    @JsonProperty("updated_time")
    private String updatedTime;

    @JsonProperty("status")
    private String status;

    @JsonProperty("swagger")
    private Swagger swagger;

    @JsonProperty("auth_content")
    private AuthContent authContent;

    @JsonProperty("version")
    private String version;

    @JsonProperty("category")
    private String category;

    @JsonProperty("need_auth")
    private boolean needAuth;

    @JsonProperty("auth_id")
    private String authId;

    @JsonProperty("action_count")
    private int actionCount;

    @JsonProperty("trigger_count")
    private int triggerCount;

    @JsonProperty("provider_name")
    private String providerName;

    @JsonProperty("release_version")
    private String releaseVersion;

    @JsonProperty("swagger_versionId")
    private String swaggerVersionId;

    @JsonProperty("favorite")
    private String favorite;
}
