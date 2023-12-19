package com.wendy.grpc.dao.po;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
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
@Entity
@Table(name="t_book")
public class BookPo {
    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    private long id;

    @Column(name = "book_name")
    private String bookName;

    @Column(name = "author")
    private String author;

    @Column(name = "publisher")
    private String publisher;

    @Column(name = "published_date")
    private Date publishedDate;
}
