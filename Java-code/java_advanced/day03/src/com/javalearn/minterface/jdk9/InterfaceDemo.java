package com.javalearn.minterface.jdk9;

public class InterfaceDemo {
    /*
        JDK9的新特性 : 允许定义私有方法
     */
    public static void main(String[] args) {

    }
}

interface Inter {

    void show();

    void print();

    public static void start() {
        System.out.println("start开始执行...");
        log();
    }

    public static void end() {
        System.out.println("end开始执行...");
        log();
    }

    public static void log() {
        System.out.println("日志记录");
    }
}
