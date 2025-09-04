package com.javalearn.mobject.p2_equals;

import java.util.Objects;

public class Student {
    private String name;
    private int age;

    public Student() {
    }

    /*@Override
    public boolean equals(Object obj) {
        if (obj instanceof Student) {
            // this : 发起比较的对象
            // obj : 被计较的对象
            // 向下转型的目的，是为了调用子类特有的成员
            Student stu = (Student) obj;
            // return this.age == obj.age
            return age == stu.age && name.equals(stu.name);
        } else {
            return false;
        }
    }*/

    @Override
    public boolean equals(Object o) {
        // 两个对象做地址值的比较，如果地址值相同，里面的内容也肯定相同，直接返回true
        if (this == o) return true;

        // 代码要是能够走到这里，代表地址值肯定不相同
        // 代码要是能够走到这里，代表stu1，肯定不是null，否则会产生 空指针异常
        // stu1不是null，stu2是null，就直接返回false

        // this.getClass() != o.getClass() : 两个对象的字节码是否相同
        // 如果字节码不相同，就意味着类型不同，直接返回false
        if (o == null || getClass() != o.getClass()) return false;

        // 代码要是走到这里，代表字节码相同，类型肯定相同。
        // 向下转型
        Student student = (Student) o;
        // 比较
        return age == student.age && Objects.equals(name, student.name);
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
