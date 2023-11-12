package com.wendy.jpa.entity;

import lombok.Data;

import java.util.List;

/**
 * @Description TODO
 * @Author wendyma
 * @Date 2023/11/11 16:00
 * @Version 1.0
 */
@Data
public class BlogPage {
    private int total;

    private List<BlogVo> blogVoList;
}
