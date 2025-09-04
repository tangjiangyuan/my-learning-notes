package com.javalearn.p1_mstatic;

public class StaticDemo02 {

    static int num1 = 10;

    int num2 = 20;

    public static void method() {
        System.out.println("Method...");
    }

    public void print() {
        System.out.println("print...");
    }
    public static void main(String[] args) {
        // 在静态方法中，只能访问静态成员（直接访问）
        System.out.println(num1);
        method();

        StaticDemo02 sd = new StaticDemo02();
        System.out.println(sd.num2);
        sd.print();
    }
}
