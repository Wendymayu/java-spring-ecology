package com.wendy.json.service;

import com.wendy.json.entity.Connector;

/**
 * @Description TODO
 * @Author wendyma
 * @Date 2023/10/8 23:22
 * @Version 1.0
 */
public interface JacksonDemoService {
    /**
     * 讲对象以序列化为json文件
     *
     * @param connector
     * @return
     */
    String writeJson(Connector connector);

    /**
     * 从json文件读取对象
     *
     * @return
     */
    Connector readJson();

    /**
     * 以jsonPtrExpr获取json属性
     *
     * @param path 例如 /swagger/info/version
     * @return
     */
    Object getJsonProperty(String path);
}