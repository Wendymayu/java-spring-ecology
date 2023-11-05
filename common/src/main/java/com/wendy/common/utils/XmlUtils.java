package com.wendy.common.utils;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.fasterxml.jackson.dataformat.xml.XmlMapper;
import com.fasterxml.jackson.dataformat.xml.ser.ToXmlGenerator;
import lombok.extern.slf4j.Slf4j;

import java.io.IOException;
import java.util.Objects;

/**
 * @Description XML使用工具类
 * @Author wendyma
 * @Date 2023/10/1 5:46
 * @Version 1.0
 */
@Slf4j
public class XmlUtils {
    private static XmlMapper xmlMapper;

    private static XmlMapper getInstance() {
        if (!Objects.isNull(xmlMapper)) {
            return xmlMapper;
        }
        xmlMapper = new XmlMapper();
        // 以下这个配置会导致运行时异常
        //xmlMapper.configure(SerializationFeature.INDENT_OUTPUT, true);

        // 设置xml根节点名字
        xmlMapper.configure(SerializationFeature.WRAP_ROOT_VALUE, false);

        // xml版本声明、编码等头信息
        xmlMapper.configure(ToXmlGenerator.Feature.WRITE_XML_DECLARATION, true);
        // xmlMapper.configure(ToXmlGenerator.Feature.WRITE_XML_1_1, true);
        return xmlMapper;
    }

    public static <T> Object xml2Bean(String xml, TypeReference<T> typeReference) {
        try {
            return xmlMapper.readValue(xml, typeReference);
        } catch (IOException e) {
            throw new RuntimeException("Xml to bean error.");
        }
    }

    public static <T> Object xml2Bean(String xml, Class<T> clazz) {
        try {
            return xmlMapper.readValue(xml, clazz);
        } catch (IOException e) {
            throw new RuntimeException("Xml to bean error.");
        }
    }

    public static String bean2Xml(Object object) {
        try {
            return xmlMapper.writer().withRootName("root").writeValueAsString(object);
        } catch (JsonProcessingException e) {
            log.error("Object to xml error, the reason is {}", e.getMessage());
            throw new RuntimeException("Object to xml error");
        }
    }

    public static String xml2Json(String xml) {
        try {
            Object object = xmlMapper.readValue(xml, Object.class);
            ObjectMapper objectMapper = new ObjectMapper();
            return objectMapper.writeValueAsString(object);
        } catch (IOException e) {
            log.error("Xml to json error, the reason is {}", e.getMessage());
            throw new RuntimeException("Xml to json error");
        }
    }

    public static String json2Xml(String json) {
        try {
            xmlMapper = getInstance();
            ObjectMapper objectMapper = new ObjectMapper();
            JsonNode jsonNode = objectMapper.readValue(json, JsonNode.class);
            return xmlMapper.writer().withRootName("root").writeValueAsString(jsonNode);
        } catch (IOException e) {
            log.error("Json to xml error, the reason is {}", e.getMessage());
            throw new RuntimeException("Json to xml error");
        }
    }
}
