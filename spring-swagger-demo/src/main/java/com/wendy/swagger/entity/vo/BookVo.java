package com.wendy.swagger.entity.vo;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.util.Date;

/**
 * @Description TODO
 * @Author wendyma
 * @Date 2023/11/5 15:46
 * @Version 1.0
 */
@ApiModel(value = "图书实体类")
@Data
public class BookVo {
    @ApiModelProperty(value = "图书Id")
    private long id;

    @ApiModelProperty(value = "图书名", required = true)
    private String bookName;

    @ApiModelProperty(value = "图书作者", required = true)
    private String author;

    @ApiModelProperty(value = "图书出版社")
    private String publisher;

    @ApiModelProperty(value = "图书出版日期")
    private Date publishedDate;
}
