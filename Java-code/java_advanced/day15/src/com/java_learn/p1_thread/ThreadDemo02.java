package com.java_learn.p1_thread;

/**
 * @author tjy
 * @version 1.0
 * @date 2025/7/22 19:03
 */
public class ThreadDemo02 {
    /*
        Java 程序默认是多线程的，程序启动后默认会存在两条线程
            1. 主线程
            2. 垃圾回收线程
     */
    public static void main(String[] args) {
        for (int i = 0; i < 5000000; i++) {
            new Demo();
        }
    }
}

class Demo {
    @Override
    protected void finalize() throws Throwable {
        System.out.println("垃圾清理了");
    }
}