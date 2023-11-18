package com.wendy.demo.service;

/**
 * @Description TODO
 * @Author wendyma
 * @Date 2023/11/18 13:20
 * @Version 1.0
 */
public interface HelloService {
    /**
     * 耗时操作，用于测试方法异步执行
     * @param name
     */
    void hello(String name);
}