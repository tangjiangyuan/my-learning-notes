package com.javalearn.c;

import com.javalearn.a.Student;

public class Test {
    public static void main(String[] args) {
        Student stu1 = new Student();
        stu1.study();

        /*
            当我们想要调用两个不同包下的类，且这两个类名一样，第一个写导包代码，第二个就需要通过 全类名调用（包名+类名）
         */
        com.javalearn.b.Student stu2 = new com.javalearn.b.Student();
        stu2.sleep();
    }
}
