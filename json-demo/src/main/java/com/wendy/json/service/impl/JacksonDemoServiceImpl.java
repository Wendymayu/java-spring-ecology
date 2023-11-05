package com.wendy.json.service.impl;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.wendy.common.utils.JsonUtils;
import com.wendy.json.entity.Connector;
import com.wendy.json.service.JacksonDemoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;
import org.springframework.core.io.ResourceLoader;
import org.springframework.stereotype.Service;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.nio.charset.StandardCharsets;

/**
 * @Description TODO
 * @Author wendyma
 * @Date 2023/10/8 23:23
 * @Version 1.0
 */
@Service
public class JacksonDemoServiceImpl implements JacksonDemoService {
    private static final String OUTPUT_JSON = "classpath:/json/output.json";

    @Autowired
    private ResourceLoader resourceLoader;

    @Override
    public String writeJson(Connector connector) {
        try {
            // ResourceLoader可以将数据写入resources下的文件
            Resource resource = resourceLoader.getResource(OUTPUT_JSON);
            File file = resource.getFile();
            if (!file.exists()) {
                file.createNewFile();
            }
            ObjectMapper objectMapper = new ObjectMapper();
            objectMapper.writeValue(file, connector);
        } catch (IOException e) {
            System.out.println(e);
            throw new RuntimeException("write object to json error.");
        }
        return "success";
    }

    @Override
    public Connector readJson() {
        try {
            InputStream inputStream = this.getClass().getClassLoader().getResourceAsStream("json/output.json");
            StringBuilder sb = new StringBuilder();
            byte[] data = new byte[1024];
            while (inputStream.read(data) != -1) {
                sb.append(new String(data, StandardCharsets.UTF_8));
            }
            return JsonUtils.json2Object(sb.toString(), Connector.class);
        } catch (IOException e) {
            throw new RuntimeException("Read json from output.json error.");
        }
    }

    @Override
    public Object getJsonProperty(String path) {
        ClassPathResource resource = new ClassPathResource("json/output.json");
        try (InputStream inputStream = resource.getInputStream()) {
            ObjectMapper objectMapper = new ObjectMapper();
            JsonNode jsonNode = objectMapper.readTree(inputStream);
            return jsonNode.at(path).asText();
        } catch (IOException e) {
            throw new IllegalArgumentException("Path is invalid");
        }
    }
}
