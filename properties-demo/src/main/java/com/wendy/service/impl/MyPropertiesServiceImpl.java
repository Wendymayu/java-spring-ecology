package com.wendy.service.impl;

import com.wendy.service.MyPropertiesService;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

/**
 * @Description TODO
 * @Author wendyma
 * @Date 2023/10/1 22:32
 * @Version 1.0
 */
@Service
public class MyPropertiesServiceImpl implements MyPropertiesService {
    @Override
    public String getProperty(String key) {
        InputStream inputStream = this.getClass().getClassLoader().getResourceAsStream("my.properties");
        Properties properties = new Properties();
        try {
            properties.load(inputStream);
            String property = properties.getProperty("server.port");
            System.out.println(property);
            return property;
        } catch (IOException e) {
            throw new RuntimeException("Read property from file error.");
        }
    }
}
