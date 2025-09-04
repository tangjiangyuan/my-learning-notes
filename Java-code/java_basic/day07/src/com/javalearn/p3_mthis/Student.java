package com.javalearn.p3_mthis;

public class Student {

    String name;

    public void sayHello(String name) {
        System.out.println("局部变量 : " + name);           // "橙留香"
        System.out.println("成员变量 : " + this.name);      // "菠萝吹雪"
    }

    // this介绍 : 就是代表当前类对象的引用地址
    public void print() {
        System.out.println("print方法中打印this关键字 --> " + this);
    }
}
