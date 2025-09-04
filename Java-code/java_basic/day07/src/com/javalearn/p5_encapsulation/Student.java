package com.javalearn.p5_encapsulation;


/*
    1. 私有化成员变量（为了保证数据的安全性）

    2. 针对私有的成员变量，提供对应的setXxx和getXxx方法

            set : 设置
            get : 获取
 */
public class Student {

    private int age;

    public void setAge(int age) {
        if (age >= 0 && age <= 120) {
            this.age = age;
        }else {
            System.out.println("输入错误！");
        }
    }

    public int getAge() {
        return age;
    }
}
