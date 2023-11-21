package com.wendy.redis.entity;

import lombok.Data;

import java.util.List;

/**
 * @Description TODO
 * @Author wendyma
 * @Date 2023/11/18 23:53
 * @Version 1.0
 */
@Data
public class VoList<T> {
    private int total;

    private List<T> voList;
}
