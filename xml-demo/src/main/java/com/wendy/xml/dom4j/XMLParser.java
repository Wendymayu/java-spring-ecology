package com.wendy.xml.dom4j;

import com.wendy.xml.entity.Dependency;
import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.Element;
import org.dom4j.io.SAXReader;
import org.springframework.core.io.ClassPathResource;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

/**
 * @Description TODO
 * @Author wendyma
 * @Date 2022/3/2 21:25
 * @Version 1.0
 */
public class XMLParser {
    public static final String WEBSITE_INFO = "xml/website.xml";

    public List<Dependency> parseXML() {
        List<Dependency> dependencyList = new ArrayList<>();
        ClassPathResource resource = new ClassPathResource(WEBSITE_INFO);
        try (InputStream inputStream = resource.getInputStream()) {
            // 创建一个SAXReader解析器
            SAXReader saxReader = new SAXReader();
            // 读取xml文件,转换成Document结点
            Document document = saxReader.read(inputStream);
            // 获取xml的根元素
            Element rootElement = document.getRootElement();
            // 获取根元素的子节点，子节点有多个所以返回集合
            List<Element> dependencies = rootElement.elements();
            for (Element element : dependencies) {
                String groupId = element.elementText("groupId");
                String artifactId = element.elementText("artifactId");
                String version = element.elementText("version");
                Dependency dependency = new Dependency();
                dependency.setGroupId(groupId);
                dependency.setArtifactId(artifactId);
                dependency.setVersion(version);
                dependencyList.add(dependency);
            }
        } catch (DocumentException | IOException e) {
            e.printStackTrace();
        }
        return dependencyList;
    }
}
