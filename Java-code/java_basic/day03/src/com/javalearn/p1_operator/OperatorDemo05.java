package com.javalearn.p1_operator;

import java.util.Scanner;

public class OperatorDemo05 {
    /*
        三元运算符：
            判断条件?值1:值2
     */
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("请输入你的年龄：");
        int age = sc.nextInt();

        System.out.println(age > 18?0:1);// 0:允许；1:不允许
    }
}
