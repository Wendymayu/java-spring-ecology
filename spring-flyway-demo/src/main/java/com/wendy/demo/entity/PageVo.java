package com.wendy.demo.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

/**
 * @Description TODO
 * @Author wendyma
 * @Date 2023/11/22 23:20
 * @Version 1.0
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class PageVo<T> {
    private long total;

    private List<T> datas;
}
