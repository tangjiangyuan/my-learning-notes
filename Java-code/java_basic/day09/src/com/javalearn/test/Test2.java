package com.javalearn.test;

import com.javalearn.domain.Student;

import java.util.ArrayList;
import java.util.Scanner;

public class Test2 {
    /*
        需求 : 创建一个存储学生对象的集合，存储3个学生对象，使用程序实现在控制台遍历该集合
                学生的姓名和年龄来自于键盘录入
     */
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.println("请输入第一名学生的姓名:");
        String name1 = sc.next();
        System.out.println("请输入第一名学生的年龄:");
        int age1 = sc.nextInt();
        Student stu1 = new Student(name1, age1);

        System.out.println("请输入第二名学生的姓名:");
        String name2 = sc.next();
        System.out.println("请输入第二名学生的年龄:");
        int age2 = sc.nextInt();
        Student stu2 = new Student(name2, age2);

        System.out.println("请输入第三名学生的姓名:");
        String name3 = sc.next();
        System.out.println("请输入第三名学生的年龄:");
        int age3 = sc.nextInt();
        Student stu3 = new Student(name3, age3);

        ArrayList<Student> list = new ArrayList<>();

        list.add(stu1);
        list.add(stu2);
        list.add(stu3);
        for (int i = 0; i < list.size(); i++) {
            Student student = list.get(i);
            System.out.println(student.getName() + "---" + student.getAge());
        }

    }
}
