package com.javalearn.p5_encapsulation;

public class StudentTest {
    /*
        封装的设计规范 : 合理隐藏，合理暴露
     */
    public static void main(String[] args) {
        Student stu = new Student();
        stu.setAge(23);
        int age = stu.getAge();
        System.out.println(age);
    }
}
