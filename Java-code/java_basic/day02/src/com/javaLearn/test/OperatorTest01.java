package com.javaLearn.test;

import java.util.Scanner;

public class OperatorTest01 {
    /*
        数值拆分
        需求：键盘录入一个三位数，将其拆分为个位、十位和百位，打印在控制台
        个：数值 % 10；
        十：数值 / 10 % 10；
        百：数值 / 10 / 10 % 10；
        千：数值 / 10 / 10 / 10 % 10；
        万：数值 / 10 / 10 / 10 / 10 % 10；
        ···
        对于最高位，可做简化处理
        百：数值 / 100；
        千：数值 / 1000；
        万：数值 / 10000；
     */
    public static void main(String[] args) {
        // 从键盘录入一个三位数
        Scanner sc = new Scanner(System.in);
        System.out.println("请输入：");
        int num = sc.nextInt();

        int ge = num % 10;
        int shi = num / 10 % 10;
        int bai = num / 100;

        System.out.println(num+"的个位是："+ge);
        System.out.println(num+"的十位是："+shi);
        System.out.println(num+"的百位是："+bai);
    }
}
