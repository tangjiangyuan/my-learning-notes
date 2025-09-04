package com.javalearn.p1_recursion;

public class RecursionDemo4 {
    /*
        斐波那契数列:从第三个数字开始，每一个数字都等于前两个数字之和。
     */
    public static void main(String[] args) {
        int result = fibonacci(8);
        System.out.println(result);
    }

    public static int fibonacci(int num) {
        if (num > 0 && num <= 2) return 1;
        else return fibonacci(num - 1) + fibonacci(num - 2);
    }
}
