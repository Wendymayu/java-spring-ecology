package com.wendy.jpa.dao.po;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.repository.CrudRepository;

import javax.persistence.*;
import java.util.Date;
import java.util.List;

/**
 * @Description TODO
 * @Author wendyma
 * @Date 2023/11/11 15:43
 * @Version 1.0
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "t_blog")
public class BlogPo {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    @Column(name = "title")
    private String title;

    @Column(name = "author_id")
    private String authorId;

    @Column(name = "content")
    private String content;

    @Column(name = "classify_id")
    private String classifyId;

    @Column(name = "visibility")
    private String visibility;

    @Column(name = "tags")
    private String tagIds;

    @Column(name = "created_time")
    private Date createdTime;

    @Column(name = "updated_time")
    private Date updatedTime;
}
