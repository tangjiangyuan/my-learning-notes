package com.java_learn.p4_single_design_pattern;

/**
 * @author tjy
 * @version 1.0
 * @date 2025/7/24 9:12
 */
public class SingletonDesignDemo01 {
    /*
        单例设计模式 --- 饿汉式
     */
    public static void main(String[] args) {
        Singleton1 instance1 = Singleton1.getInstance();
        Singleton1 instance2 = Singleton1.getInstance();
        System.out.println(instance1 == instance2); // true
    }
}

class Singleton1 {
    // 1. 私有该类的构造方法，防止创建对象
    private Singleton1() {}
    // 2. 定义一个变量接收自己创建的对象
    private static final Singleton1 Instance = new Singleton1();
    // 3. 提供一个唯一的全局接入点
    public static Singleton1 getInstance() {
        return Instance;
    }
}