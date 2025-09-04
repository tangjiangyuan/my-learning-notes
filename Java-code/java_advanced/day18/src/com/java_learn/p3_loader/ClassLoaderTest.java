package com.java_learn.p3_loader;

/**
 * @author tjy
 * @version 1.0
 * @date 2025/7/25 10:26
 */
public class ClassLoaderTest {
    public static void main(String[] args) {
        // 1. 加载 jdk自带的类加载器 Bootstrap Classloader (启动类加载器)
        ClassLoader loader1 = String.class.getClassLoader();
        // System.out.println(loader1);

        // 2. Platform Classloader (平台类加载器) lib\modules

        // 3. Application ClassLoader(系统类加载器) 加载自己编写的类
        ClassLoader loader2 = ClassLoaderTest.class.getClassLoader();
        System.out.println(loader2);

        // 4. 测试类加载器的上下级关系
        System.out.println(loader2.getParent());
        System.out.println(loader2.getParent().getParent());

    }
}
