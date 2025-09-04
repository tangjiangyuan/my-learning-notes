package com.javalearn.p1_recursion;

public class RecursionDemo2 {
    /*
        需求：使用递归求5的阶乘
     */
    public static void main(String[] args) {
        int result = factorial(5);
        System.out.println(result);
    }

    public static int factorial(int num) {
        if (num == 1) {
            return 1;
        } else {
            return num * factorial(num - 1);
        }
    }
}
