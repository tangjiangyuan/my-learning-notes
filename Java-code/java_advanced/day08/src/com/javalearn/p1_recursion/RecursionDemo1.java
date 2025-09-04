package com.javalearn.p1_recursion;

public class RecursionDemo1 {
    /*
        递归介绍：方法直接或间接调用本身
        注意：没有设置好终止，会出现栈内存溢出现象
     */
    public static void main(String[] args) {
        methodA();
    }

    public static void methodA() {
        methodB();
    }
    public static void methodB() {
        methodC();
    }
    public static void methodC() {
        methodA();
    }
}
