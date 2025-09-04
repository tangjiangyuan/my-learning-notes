package com.java_learn.p4_reflect.exer02.domain;

/**
 * @author tjy
 * @version 1.0
 * @date 2025/7/25 22:31
 */
public class Student {
    private String name;
    private String age;

    public Student() {
    }

    public Student(String name, String age) {
        this.name = name;
        this.age = age;
    }

    public void study() {
        System.out.println("学生学习");
    }

    public void eat() {
        System.out.println("学生吃饭");
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
    public String getAge() {
        return age;
    }

    /**
     * 设置
     * @param age
     */
    public void setAge(String age) {
        this.age = age;
    }

    public String toString() {
        return "Student{name = " + name + ", age = " + age + "}";
    }
}
