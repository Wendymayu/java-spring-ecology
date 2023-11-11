package com.wendy.jdbc.pojo;

import lombok.Data;

import java.util.Date;

/**
 * @Description TODO
 * @Author wendyma
 * @Date 2022/7/10 12:14
 * @Version 1.0
 */
@Data
public class BookVo {
    private long id;

    private String bookName;

    private String author;

    private String publisher;

    private Date publishedDate;
}
