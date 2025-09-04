package com.javalearn.test;

public class MethodTest01 {
    /*
        案例：方法计算两个整数最大值
        需求：定义一个方法，方法中定义两个整数变量，求出最大值并打印在控制台
     */
    public static void main(String[] args) {

        int result = getMax(10,29);// 实参

        System.out.println("最大值是：" + result);
    }

    public static int getMax(int num1,int num2) {// 形参

        int max = num1 > num2 ? num1 : num2;

        return max;
    }
}
