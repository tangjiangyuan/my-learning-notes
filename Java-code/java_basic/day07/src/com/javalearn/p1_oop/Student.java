package com.javalearn.p1_oop;

/*
    类的组成

        属性(名词) : 在代码中使用成员变量表示，成员变量跟之前定义变量的格式一样，只不过是在 类中方法外。

        行为(动词) : 在代码中使用成员方法表示，成员方法跟之前定义方法的格式一样，只不过要去掉 static 关键字。
 */
public class Student {
    // 属性
    String name;
    int age;

    // 行为
    public void study() {
        System.out.println("学习");
    }

    public void eat() {
        System.out.println("吃饭");
    }
}
