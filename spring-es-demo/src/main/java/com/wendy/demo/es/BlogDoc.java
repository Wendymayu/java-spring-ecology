package com.wendy.demo.es;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.elasticsearch.annotations.Document;
import org.springframework.data.elasticsearch.annotations.Field;
import org.springframework.data.elasticsearch.annotations.FieldType;

import java.util.Date;

/**
 * @Description TODO
 * @Author wendyma
 * @Date 2023/11/23 23:37
 * @Version 1.0
 */
@Data
@Document(indexName = "blog", createIndex = true)
public class BlogDoc {
    @Id
    @Field(type = FieldType.Long)
    private long id;

    @Field(type = FieldType.Text)
    private String title;

    @Field(type = FieldType.Keyword)
    private String authorId;

    @Field(type = FieldType.Text)
    private String content;

    @Field(type = FieldType.Text)
    private String classification;

    @Field(type = FieldType.Text)
    private String visibility;

    @Field(type = FieldType.Date)
    private Date createdTime;

    @Field(type = FieldType.Date)
    private Date updatedTime;
}
