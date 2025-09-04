package com.javalearn.p1_recursion;

public class RecursionDemo3 {
    /*
        练习：使用递归求 1~n的和
     */
    public static void main(String[] args) {
        int sum = getSum(50);
        System.out.println(sum);
    }

    public static int getSum(int num) {
        if (num == 1) return 1;
        else return num + getSum(num - 1);
    }
}
