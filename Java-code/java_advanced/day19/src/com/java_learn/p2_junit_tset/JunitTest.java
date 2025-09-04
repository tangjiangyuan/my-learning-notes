package com.java_learn.p2_junit_tset;

import org.junit.Test;

/**
 * @author tjy
 * @version 1.0
 * @date 2025/7/26 10:00
 */
public class JunitTest {

    @Test
    public void show() {
        System.out.println("show...");
    }

    @Test
    public void print() {
        System.out.println(10 / 0);
        System.out.println("print...");
    }

    @Test
    public void method() {
        System.out.println("method...");
    }
}
