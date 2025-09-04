package com.java_learn.p3_loader;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

/**
 * @author tjy
 * @version 1.0
 * @date 2025/7/25 11:24
 */
public class ClassLoaderMethod {
    public static void main(String[] args) throws IOException {
        // 获取系统类加载器
        ClassLoader systemClassLoader = ClassLoader.getSystemClassLoader();
        System.out.println(systemClassLoader);

        // 通过系统类加载器，加载配置文件
        // 因为系统类加载器加载我们自己写的类，自己编写的类都在src文件夹下，就不用写前面的路径
        InputStream is = systemClassLoader.getResourceAsStream("config.properties");

        Properties prop = new Properties();
        prop.load(is);
        is.close();

        String username = prop.getProperty("username");
        String password = prop.getProperty("password");

        System.out.println(username);
        System.out.println(password);
    }
}
