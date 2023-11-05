package com.wendy.swagger.entity.vo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

/**
 * @Description TODO
 * @Author wendyma
 * @Date 2023/9/17 10:42
 * @Version 1.0
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class PageVo<T> {
    private long total;

    private List<T> datas;
}
