package com.wendy.demo.dao;

import lombok.Data;

import java.util.Date;

/**
 * @Description TODO
 * @Author wendyma
 * @Date 2023/12/1 0:01
 * @Version 1.0
 */
@Data
public class BookPo {
    private long id;

    private String bookName;

    private String author;

    private String publisher;

    private Date publishedDate;
}
