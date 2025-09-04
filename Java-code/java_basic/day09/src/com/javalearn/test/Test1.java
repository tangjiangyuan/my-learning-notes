package com.javalearn.test;

import com.javalearn.domain.Student;

import java.util.ArrayList;

public class Test1 {
    public static void main(String[] args) {
        /*
            需求 : 创建一个存储学生对象的集合，存储3个学生对象，在控制台，展示出年龄低于18岁的学生信息
         */
        Student s1 = new Student("张三", 23);
        Student s2 = new Student("李四", 14);
        Student s3 = new Student("王五", 15);

        ArrayList<Student> list = new ArrayList<>();

        list.add(s1);
        list.add(s2);
        list.add(s3);

        for (int i = 0; i < list.size(); i++) {
            Student stu = list.get(i);
            if (stu.getAge() <= 18) {
                System.out.println(stu.getName() + "---" + stu.getAge());
            }
        }

    }

    /*
            需求 : 创建一个存储字符串的集合，内部存储字符串元素

                钢门吹雪、西域狂鸭、张三、阿雅、李四
                使用程序实现在控制台遍历该集合，将4个字的人名，打印在控制台
         */
    private static void exercise2() {
        ArrayList<String> list = new ArrayList<>();

        list.add("钢门吹雪");
        list.add("西域狂鸭");
        list.add("张三");
        list.add("阿雅");
        list.add("李四");

        for (int i = 0; i < list.size(); i++) {
            String element = list.get(i);
            if (element.length() == 4) {
                System.out.println(element);
            }
        }
    }

    /*
        练习1 : 集合存储字符串并遍历
        需求 : 创建一个存储字符串的集合，内部存储3个字符串元素，使用程序实现在控制台遍历该集合
     */
    private static void exercise1() {
        ArrayList<String> list = new ArrayList<>();

        list.add("张三");
        list.add("李四");
        list.add("王五");

        for (int i = 0; i < list.size(); i++) {
            String s = list.get(i);
            System.out.println(s);
        }
    }
}
