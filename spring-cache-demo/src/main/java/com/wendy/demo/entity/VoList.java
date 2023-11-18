package com.wendy.demo.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

/**
 * @Description TODO
 * @Author wendyma
 * @Date 2023/11/18 15:05
 * @Version 1.0
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class VoList<T> {
    private int total;

    private List<T> vos;
}
