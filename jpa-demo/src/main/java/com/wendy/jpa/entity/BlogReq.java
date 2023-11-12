package com.wendy.jpa.entity;

import lombok.Data;

import java.util.Date;
import java.util.List;

/**
 * @Description TODO
 * @Author wendyma
 * @Date 2023/11/11 15:37
 * @Version 1.0
 */
@Data
public class BlogReq {
    private String title;

    private String authorId;

    private String content;

    private String classify;

    private List<String> tags;

    private String visibility;

    private Date createdTime;

    private Date updatedTime;
}
