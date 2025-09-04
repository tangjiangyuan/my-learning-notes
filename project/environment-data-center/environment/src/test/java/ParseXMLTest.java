import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.Element;
import org.dom4j.io.SAXReader;
import org.junit.jupiter.api.Test;

import java.io.FileReader;
import java.lang.reflect.Constructor;
import java.lang.reflect.Method;
import java.util.*;

/**
 * @version 1.0
 * @date 2025/8/29 15:28
 */
public class ParseXMLTest {

    @Test
    public void testParse() throws Exception {
        Map<String, Element> map = new HashMap<>();
        Properties prop = new Properties();

        SAXReader reader = new SAXReader();
        Document document = reader.read("src/main/resources/config.xml");
        Element rootElement = document.getRootElement();

        List<Element> elements = rootElement.elements();
        for (Element module : elements) {
            map.put(module.getName(), module);
        }

        Element module = map.get("Backup");
        List<Element> ele = module.elements();
        for (Element element : ele) {
            prop.setProperty(element.getName(), element.getText());
        }

        Set<Map.Entry<Object, Object>> entries = prop.entrySet();
        for (Map.Entry<Object, Object> entry : entries) {
            System.out.println(entry.getKey() + "---" + entry.getValue());
        }

    }
}
