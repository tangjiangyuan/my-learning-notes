package com.java_learn.p5_properties;

import java.util.Properties;
import java.util.Set;

public class PropertiesDemo1 {
    /*
        Properties 作为集合的使用
            Object setProperty(String key, String value) : 类似 Map集合的put方法
            String getProperty(String key) :    类似 Map集合的get方法
            Set<String> stringPropertyNames() :  类似 Map集合的keySet方法
     */
    public static void main(String[] args) {
        Properties properties = new Properties();
        properties.setProperty("username", "admin");
        properties.setProperty("password", "1234");

        // getPropertiesMethod(properties);
        Set<String> keySet = properties.stringPropertyNames();
        for (String key : keySet) {
            System.out.println(key + "---" + properties.getProperty(key));
        }

        // System.out.println(properties);
    }

    private static void getPropertiesMethod(Properties properties) {
        String username = properties.getProperty("username");
        String password = properties.getProperty("password");
        System.out.println(username);
        System.out.println(password);
    }
}
