package com.javalearn.p1_generics;

public class GenericsDemo2 {
    /*
        泛型类 : 创建对象的时候，要确定类型

        常见的泛型标识符 ： E V K T

            E : Element
            T : Type
            K : Key (键)
            V : Value (值)

        清楚不同的泛型，在什么时机能确定到具体的类型
     */
    public static void main(String[] args) {

        Student<Integer> stu = new Student<>();

    }
}

class Student<E> {
    private E e;

    public Student() {
    }

    public Student(E e) {
        this.e = e;
    }

    /**
     * 获取
     */
    public E getE() {
        return e;
    }

    /**
     * 设置
     */
    public void setE(E e) {
        this.e = e;
    }

    public String toString() {
        return "Student{e = " + e + "}";
    }
}
