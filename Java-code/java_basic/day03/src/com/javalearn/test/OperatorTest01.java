package com.javalearn.test;

import java.util.Scanner;

public class OperatorTest01 {
    /*
        案例:求最大值
        需求：键盘录入三个整数，求出最大值并打印在控制台
     */
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.println("请输入第一个整数：");
        int num1 = sc.nextInt();
        System.out.println("请输入第二个整数：");
        int num2 = sc.nextInt();
        System.out.println("请输入第三个整数：");
        int num3 = sc.nextInt();

        int max1 = num1 > num2 ? num1:num2;
        int max2 = max1 > num3 ? max1:num3;

        System.out.println("最大值为："+max2);
    }
}

