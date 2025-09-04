package com.javalearn.p3_mthis;

public class ThisDemo01 {
    public static void main(String[] args) {
        Student stu1 = new Student();
        stu1.name = "菠萝吹雪";
        stu1.sayHello("橙留香");

        System.out.println(stu1);
        stu1.print();
    }
}
