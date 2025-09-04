package com.java_learn.p5_properties;

import java.io.*;
import java.util.Properties;
import java.util.Set;

public class PropertiesDemo2 {
    /*
        Properties 和 IO 有关的方法
            void load(InputStream inStream) : 从输入字节流读取属性列表(键和元素对)
            void load(Reader reader) :          从输入字符流读取属性列表(键和元素对)
            void store(OutputStream out, String comments) : 将集合的键值对写出到文件(字节流)
            void store(Writer writer, String comments) :    将集合的键值对写出到文件(字符流)

            --- String comments 注释
     */
    public static void main(String[] args) throws IOException {
        test();
    }

    private static void loadMethod() throws IOException {
        Properties prop = new Properties();
        FileReader fr = new FileReader("day14\\config.properties");

        prop.load(fr); // load加载后，数据就到 prop集合中了
        fr.close();

        Set<String> keySet = prop.stringPropertyNames();
        for (String key : keySet) {
            System.out.println(key + "---" + prop.getProperty(key));
        }
    }

    private static void storeMethod() throws IOException {
        Properties prop = new Properties();
        prop.setProperty("username", "admin");
        prop.setProperty("password", "1234");

//        FileOutputStream fos = new FileOutputStream("day14\\config.properties");
//        prop.store(fos, null); // 写出形式是 十六进制
//        fos.close();

        FileWriter fw = new FileWriter("day14\\config.properties");
        prop.store(fw, null);
        fw.close();
    }

    private static void test() throws IOException{
        // 写入到文件 store
        Properties prop = new Properties();
        prop.setProperty("username", "yy");
        prop.setProperty("password", "1234");

        FileWriter fw = new FileWriter("day14\\config.properties");
        prop.store(fw, null);
        fw.close();

        // 读取文件 load
        FileReader fr = new FileReader("day14\\config.properties");
        prop.load(fr);
        fr.close();

        Set<String> keySet = prop.stringPropertyNames();
        for (String key : keySet) {
            System.out.println(key + "---" + prop.getProperty(key));
        }
    }
}
