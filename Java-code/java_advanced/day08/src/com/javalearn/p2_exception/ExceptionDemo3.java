package com.javalearn.p2_exception;

public class ExceptionDemo3 {
    /*
        Java 对于异常的默认处理方式 ： 向上抛出
     */
    public static void main(String[] args) {
        System.out.println("开始");
        method();
        System.out.println("结束");
    }

    private static void method() {
        System.out.println(10 / 0); // new ArithmeticException();
    }
}
