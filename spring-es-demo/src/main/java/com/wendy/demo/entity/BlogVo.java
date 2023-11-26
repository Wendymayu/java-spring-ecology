package com.wendy.demo.entity;

import lombok.Data;

import java.util.Date;

/**
 * @Description TODO
 * @Author wendyma
 * @Date 2023/11/18 23:48
 * @Version 1.0
 */
@Data
public class BlogVo {
    private long id;

    private String title;

    private String authorName;

    private String content;

    private String classification;

    private String visibility;

    private Date createdTime;

    private Date updatedTime;
}
