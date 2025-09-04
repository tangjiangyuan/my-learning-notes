package com.javalearn.domain;

import java.util.Objects;

public class Student implements Comparable<Student>{

    private String name;
    private int age;

    @Override
    public int compareTo(Student o) {
        return this.age - o.age;
    }

    @Override
    public boolean equals(Object o) {
        System.out.println("HashCode执行了。。。");
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Student student = (Student) o;
        return age == student.age && Objects.equals(name, student.name);
    }

    @Override
    public int hashCode() {
        // 弊端 ： 如果hashCode 方法固定返回相同的值，数据都会挂在一个索引下面
        // name是String类型，因为String类继承了Object类，也重写了hashCode方法
        return age + name.hashCode();
    }

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
