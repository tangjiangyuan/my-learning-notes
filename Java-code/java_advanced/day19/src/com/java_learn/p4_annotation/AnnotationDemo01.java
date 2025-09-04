package com.java_learn.p4_annotation;

/**
 * @author tjy
 * @version 1.0
 * @date 2025/7/26 13:19
 */
@SuppressWarnings("all")
public class AnnotationDemo01 {
    /*
        JDK 中常见的注解:
            @Override : 表示方法重写
            @Deprecated : 表示修饰的方法已过时
            @SuppressWarning("all") : 压制警告
     */
    public static void main(String[] args) {
        method();

        int a = 10;
        int b = 5;
        int max = a > b ? a : b;
        System.out.println(max);
    }

    @Deprecated
    public static void method() {

    }
}
