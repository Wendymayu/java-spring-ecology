package com.wendy.jpa.entity;

import lombok.Data;

import java.util.Date;

/**
 * @Description TODO
 * @Author wendyma
 * @Date 2023/11/12 9:24
 * @Version 1.0
 */
@Data
public class ClassifyVo {
    private long id;

    private String classifyName;

    private Date createdTime;

    private Date updatedTime;
}
