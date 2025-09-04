package com.javaLearn.p5_operator;

public class OperatorDemo02 {
    /*
        自增自减运算符：
        ++
        --
        int a = 10;
        ++a;
        System.out.println(a); // 11
        ---------------------------
        ++在前：先自增，再取值
        int a = 10;
        int b = ++a;
        System.out.println(a);  // 11
        System.out.println(b);  // 11
        ---------------------------
        ++在后：先取值，再自增
        int a = 10;
        int b = a++;
        System.out.println(a);  // 11
        System.out.println(b);  // 10
     */
    public static void main(String[] args) {
        int a = 10;
        a++;
        System.out.println(a); // 11
    }
}
