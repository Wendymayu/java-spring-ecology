package com.wendy.demo.entity;

import lombok.Data;

/**
 * @Description TODO
 * @Author wendyma
 * @Date 2023/12/17 22:12
 * @Version 1.0
 */
@Data
public class Book {
    private String id;
    private String name;
    private Integer pageCount;
    private Author author;
}
