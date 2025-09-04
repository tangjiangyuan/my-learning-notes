package com.javalearn.p5_map.test.domain;

import com.javalearn.p2_exception.StudentAgeException;

public class Student {
    String name;
    int age;

    public Student() {
    }

    // 给age赋值时，有两种方法，一种是带参构造，一种是set方法
    public Student(String name, int age) throws StudentAgeException {
        this.name = name;
        setAge(age);
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
    public void setAge(int age) throws StudentAgeException{
        if (age >= 0 && age <= 123) {
            this.age = age;
        } else {
            throw new StudentAgeException("年龄范围有误，在0~120之间！");
        }
    }

    public String toString() {
        return "Student{name = " + name + ", age = " + age + "}";
    }
}
