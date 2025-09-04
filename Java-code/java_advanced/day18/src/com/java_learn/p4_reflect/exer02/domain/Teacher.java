package com.java_learn.p4_reflect.exer02.domain;

/**
 * @author tjy
 * @version 1.0
 * @date 2025/7/25 22:31
 */
public class Teacher {
    private String name;
    private int age;

    public Teacher() {
    }

    public Teacher(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public void teach() {
        System.out.println("老师讲课");
    }

    public void eat() {
        System.out.println("老师吃饭");
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
        return "Teacher{name = " + name + ", age = " + age + "}";
    }
}
