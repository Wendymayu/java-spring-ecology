package com.wendy.xml.service.impl;

import com.wendy.common.utils.FileUtils;
import com.wendy.xml.entity.Dependency;
import com.wendy.xml.entity.PomReq;
import com.wendy.xml.service.Dom4jService;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
import org.dom4j.Document;
import org.dom4j.DocumentHelper;
import org.dom4j.Element;
import org.dom4j.io.OutputFormat;
import org.dom4j.io.SAXReader;
import org.dom4j.io.XMLWriter;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.io.*;
import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

/**
 * @Description TODO
 * @Author wendyma
 * @Date 2023/10/1 5:34
 * @Version 1.0
 */
@Slf4j
@Service
public class Dom4jServiceImpl implements Dom4jService {
    @Value("${file-path.pom}")
    private String pomFilePath;

    @Override
    public String generatePom(PomReq pomReq) {
        Document document = createPomDocument(pomReq);
        generatePomXml(document);
        return readPomXml();
    }

    private Document createPomDocument(PomReq pomReq) {
        // 创建一个Document实例，代表一个xml文件
        Document document = DocumentHelper.createDocument();

        // 设置maven的根属性
        Element project = document.addElement("project");
        project.addAttribute("xmlns", "http://maven.apache.org/POM/4.0.0");
        project.addAttribute("xmlns:xsi", "http://www.w3.org/2001/XMLSchema-instance");
        project.addAttribute("xsi:schemaLocation", "http://maven.apache.org/POM/4.0.0 https://maven.apache.org/xsd/maven-4.0.0.xsd");

        Element modelVersion = project.addElement("modelVersion");
        modelVersion.addText("4.0.0");

        // 设置父项目的信息
        Element parent = project.addElement("parent");
        Dependency parentInfo = pomReq.getParent();
        if (Objects.isNull(parentInfo)) {
            parent.addElement("groupId").addText("org.springframework.boot");
            parent.addElement("artifactId").addText("spring-boot-starter-parent");
            parent.addElement("version").addText("2.7.15");
            parent.addElement("relativePath");
        } else {
            parent.addElement("groupId").addText(parentInfo.getGroupId());
            parent.addElement("artifactId").addText(parentInfo.getArtifactId());
            parent.addElement("version").addText(parentInfo.getVersion());
            parent.addElement("relativePath");
        }

        // 设置项目的基本信息
        project.addElement("groupId").addText("com.wendy");
        project.addElement("artifactId").addText("xml-demo");
        project.addElement("version").addText("1.0.0-SNAPSHOT");
        project.addElement("name").addText("xml-demo");
        project.addElement("description").addText("A simple practice demo for xml using.");

        // 设置依赖的版本信息
        Element properties = project.addElement("properties");
        properties.addElement("java.version").addText("11");

        // 设置maven的依赖软件
        Element dependencies = project.addElement("dependencies");
        try {
            for (Dependency dependencyInfo : pomReq.getDependencies()) {
                Element dependency = dependencies.addElement("dependency");

                // 利用反射设置dependendy的子元素
                Class clazz = dependencyInfo.getClass();
                Field[] fields = clazz.getDeclaredFields();
                for (Field field : fields) {
                    field.setAccessible(true);
                    String fieldValue = (String) field.get(dependencyInfo);
                    if (StringUtils.isNotEmpty(fieldValue)) {
                        dependency.addElement(field.getName()).addText(fieldValue);
                    }
                }
            }
        } catch (Exception e) {
            log.error("Set project dependencies error.", e);
        }

        // 设置maven的构建插件
        Element build = project.addElement("build");
        Element plugins = build.addElement("plugins");
        Element plugin = plugins.addElement("plugin");
        plugin.addElement("groupId").addText("org.springframework.boot");
        plugin.addElement("artifactId").addText("spring-boot-maven-plugin");

        return document;
    }

    private void generatePomXml(Document document) {
        File pomXml = new File(pomFilePath);
        FileUtils.createFile(pomXml);

        // 自定义xml样式
        OutputFormat format = new OutputFormat();
        format.setIndentSize(4);  // 行缩进
        format.setNewlines(true); // 一个结点为一行
        format.setTrimText(true); // 去重空格
        format.setPadText(true);
        format.setNewLineAfterDeclaration(false); // 放置xml文件中第二行为空白行

        try {
            OutputStream outputStream = new FileOutputStream(pomXml);
            XMLWriter xmlWriter = new XMLWriter(outputStream, format);
            xmlWriter.write(document);
        } catch (Exception e) {
            throw new RuntimeException("Create maven dependency error.");
        }
    }

    private String readPomXml() {
        File pomXml = new File(pomFilePath);
        StringBuilder sb = new StringBuilder();
        try {
            char[] data = new char[1024];
            FileReader reader = new FileReader(pomXml);
            int readLen;
            while ((readLen = reader.read(data)) != -1) {
                sb.append(new String(data, 0, readLen));
            }
            return sb.toString();
        } catch (Exception e) {
            throw new RuntimeException("Read generated pom.xml error");
        }
    }

    @Override
    public List<String> getDependencies() {
        try {
            List<String> results = new ArrayList<>();
            SAXReader saxReader = new SAXReader();
            InputStream inputStream = new FileInputStream(pomFilePath);
            Document document = saxReader.read(inputStream);
            Element projectElement = document.getRootElement();
            Element dependencies = projectElement.element("dependencies");
            List<Element> elements = dependencies.elements();
            for (Element element : elements) {
                String groupId = element.elementText("groupId");
                String artifactId = element.elementText("artifactId");
                String version = element.elementText("version");
                results.add(groupId + ":" + artifactId + ":" + version);
            }
            return results;
        } catch (Exception e) {
            log.error("Get dependencies from pom.xml error, the reason is {}", e.getMessage());
            throw new RuntimeException("Get dependencies from pom.xml error");
        }
    }
}
