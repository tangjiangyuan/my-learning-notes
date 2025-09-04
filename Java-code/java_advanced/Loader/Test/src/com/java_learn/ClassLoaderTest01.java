package com.java_learn;

import java.io.IOException;

/**
 * @author tjy
 * @version 1.0
 * @date 2025/7/25 9:37
 */
public class ClassLoaderTest01 {
    /*
        jps : jps是jdk提供的一个查看当前 java进程的小工具
        HSDB(Hotspot Debugger) : 是一款内置于 SA中的 GUI测试工具，可用于调试 JVM运行时数据
        命令 : java -cp "D:\Dev-download\jdk8\lib\sa-jdi.jar;D:\Dev-download\jdk8\lib\tools.jar" sun.jvm.hotspot.HSDB
     */
    public static void main(String[] args) throws IOException {
        // 创建 B类 的类加载器对象
        ClassLoader loader = B.class.getClassLoader();
        // 观察 : 看看C类有没有加载，如果没有加载，成员变量C是什么？
        B b = new B();

        System.out.println(loader);
        System.out.println(loader.getParent());
        System.out.println(loader.getParent().getParent());
        // System.in.read();
    }
}

class B {
    C c = new C();
}

class C {

}