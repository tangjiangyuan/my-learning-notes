package com.java_learn.p4_annotation.test;

/**
 * @author tjy
 * @version 1.0
 * @date 2025/7/26 13:50
 */
public class AnnotationTest {
    @MyTest
    public void show() {
        System.out.println("show...");
    }

    @MyTest
    public void print() {
        System.out.println("print...");
    }

    public void method() {
        System.out.println("method...");
    }
}
