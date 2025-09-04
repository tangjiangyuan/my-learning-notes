package com.java_learn.domain;

/**
 * @author tjy
 * @version 1.0
 * @date 2025/7/25 15:06
 */
public class Student {
    private String name;
    private int age;

    public Student() {
    }

    Student(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public void eat() {
        System.out.println("今天吃饭了。");
    }

    public void eat(int num) {
        System.out.println("今天吃了" + num + "顿。");
    }

    public void play(String msg) {
        System.out.println("今天玩" + msg);
    }


    /**
     * 获取
     * @return name
     */
    public String getName() {
        return name;
    }

    /**
     * 设置
     * @param name
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * 获取
     * @return age
     */
    public int getAge() {
        return age;
    }

    /**
     * 设置
     * @param age
     */
    public void setAge(int age) {
        this.age = age;
    }

    public String toString() {
        return "Student{name = " + name + ", age = " + age + "}";
    }
}
