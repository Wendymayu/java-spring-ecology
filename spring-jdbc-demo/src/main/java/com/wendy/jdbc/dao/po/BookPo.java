package com.wendy.jdbc.dao.po;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

/**
 * @Description TODO
 * @Author wendyma
 * @Date 2023/9/14 23:04
 * @Version 1.0
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class BookPo {
    private long id;

    private String bookName;

    private String author;

    private String publisher;

    private Date publishedDate;
}
