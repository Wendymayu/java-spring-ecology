package com.wendy.validation.entity;

import com.wendy.validation.validator.EnumValue;
import lombok.Data;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.Date;
import java.util.List;

/**
 * @Description TODO
 * @Author wendyma
 * @Date 2023/11/7 23:23
 * @Version 1.0
 */
@Data
public class BlogReq {
    /**
     * 标题
     */
    @Size(min = 1, max = 256)
    private String title;

    /**
     * 作者id
     */
    @Valid  // 不加该注解，User成员的校验不会生效
    private User author;

    /**
     *
     */
    @Size(max = 65536)
    private String content;

    /**
     * 分类
     */
    @NotNull
    private String classify;

    /**
     * 标签
     */
    @NotNull
    private List<String> tags;

    /**
     * 文章谁人可见可见
     */
    @EnumValue(values = {"private", "public"})
    private String visibility;

    private Date createdTime;

    private Date updatedTime;
}
