package com.javalearn.test4;

public class test4 {
    /*
        开闭原则 :
            对扩展功能做开放，对代码修改做关闭
     */
    public static void main(String[] args) {
        A a1 = new A(1, 2, 3);
        A a2 = new A(4, 5, 6, 7);
    }
}
/*
    Version 1.0 版本有三个3变量
    Version 1.1 版本新增一个变量 (不要修改原有代码，可以通过方法重载进行功能扩展)
 */
class A {
    int a;
    int b;
    int c;
    int d;

    public A() {
    }

    public A(int a, int b, int c) {
        super();
        this.a = a;
        this.b = b;
        this.c = c;
    }

    public A(int a, int b, int c, int d) {
        this(a, b, c);// 将a,b,c给自己本类的带参构造赋值，然后带参构造再给成员变量赋值
        this.d = d;
    }
}
