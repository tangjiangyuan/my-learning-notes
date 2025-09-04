package com.javalearn.p1_recursion;

public class RecursionDemo5 {
    /*
        猴子吃桃，每天吃一半零一个，第十天还剩一个桃子。
     */
    public static void main(String[] args) {
        int nums = monkey(1);
        System.out.println("桃子数是:" + nums);
    }

    public static int monkey(int day) {
        if (day == 10) return 1;
        // (后一天的桃子数 + 1) * 2
        else return (monkey(day + 1) + 1) * 2;
    }
}
