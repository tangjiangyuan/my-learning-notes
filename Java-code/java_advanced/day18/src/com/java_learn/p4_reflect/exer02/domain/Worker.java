package com.java_learn.p4_reflect.exer02.domain;

/**
 * @author tjy
 * @version 1.0
 * @date 2025/7/25 22:31
 */
public class Worker {
    private String name;
    private int age;

    public Worker() {
    }

    public Worker(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public void work() {
        System.out.println("工人工作");
    }

    public void sleep() {
        System.out.println("工人睡觉");
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
        return "Worker{name = " + name + ", age = " + age + "}";
    }
}
