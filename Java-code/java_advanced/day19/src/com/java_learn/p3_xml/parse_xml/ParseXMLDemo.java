package com.java_learn.p3_xml.parse_xml;

import org.dom4j.Document;
import org.dom4j.Element;
import org.dom4j.io.SAXReader;

import java.util.List;


/**
 * @author tjy
 * @version 1.0
 * @date 2025/7/26 12:53
 */
public class ParseXMLDemo {
    public static void main(String[] args) throws Exception {
        SAXReader reader = new SAXReader();
        // 1. 关联要解析的xml文件，获取 document文档对象
        Document document = reader.read("day19\\src\\com\\java_learn\\p3_xml\\schema\\stus.xml");
        // 2. 获取根标签
        Element rootElement = document.getRootElement();
        // 3. 通过根标签，获取子标签
        List<Element> elements = rootElement.elements();
        // 4. 遍历集合，获取每一个子标签(student)
        for (Element studentElement : elements) {
            // 5. 获取 id属性
            String id = studentElement.attributeValue("id");
            // 6. 单独获取 name,age 标签
            Element nameElement = studentElement.element("name");
            Element ageElement = studentElement.element("age");
            // 7. 获取标签内部的文本
            String name = nameElement.getText();
            String age = ageElement.getText();

            System.out.println(id);
            System.out.println(name);
            System.out.println(age);
        }
    }
}
