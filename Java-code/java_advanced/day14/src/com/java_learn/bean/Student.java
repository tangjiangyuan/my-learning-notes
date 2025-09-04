package com.java_learn.bean;

import java.io.Serializable;

public class Student implements Serializable {

    private static final long serialVersionUID = -4002677418934788461L;
    private String name;
    private transient int age; // transient 瞬态关键字 作用 --- 被 transient关键字修饰的成员不参加序列化
    String gender;


    public Student() {
    }

    public Student(String name, int age) {
        this.name = name;
        this.age = age;
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
