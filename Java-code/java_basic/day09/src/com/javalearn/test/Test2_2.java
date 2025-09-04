package com.javalearn.test;

import com.javalearn.domain.Student;

import java.util.ArrayList;
import java.util.Scanner;

public class Test2_2 {
    public static void main(String[] args) {
        // 1. 创建一个集合，存放3个学生对象信息
        ArrayList<Student> list = new ArrayList<>();

        // 2. 调用添加学生信息方法，进行循环
        for (int i = 0; i < 3; i++) {
            System.out.println("---请输入第" + (i + 1) + "个学生的信息---");
            addStudentsInfos(list);
        }
        // 3. 遍历集合，拿到每一个学生信息
        for (int i = 0; i < list.size(); i++) {
            Student student = list.get(i);
            System.out.println(student.getName() + "---" + student.getAge());
        }

    }

    /**
     * 添加学生信息
     *
     * @param list 将信息存入list中
     */
    private static void addStudentsInfos(ArrayList<Student> list) {
        Scanner sc = new Scanner(System.in);
        System.out.println("请输入学生姓名:");
        String name = sc.next();
        System.out.println("请输入学生年龄:");
        int age = sc.nextInt();

        Student student = new Student(name, age);
        list.add(student);
    }
}
