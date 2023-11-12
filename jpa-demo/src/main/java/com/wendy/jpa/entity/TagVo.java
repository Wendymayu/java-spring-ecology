package com.wendy.jpa.entity;

import lombok.Data;

import javax.persistence.Column;
import java.util.Date;

/**
 * @Description TODO
 * @Author wendyma
 * @Date 2023/11/12 9:21
 * @Version 1.0
 */
@Data
public class TagVo {
    private long id;

    private String tagName;

    private Date createdTime;

    private Date updatedTime;
}
