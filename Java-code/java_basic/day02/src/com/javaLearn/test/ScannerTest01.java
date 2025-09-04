package com.javaLearn.test;

import java.util.Scanner;

public class ScannerTest01 {
    /*
        需求：请使用Scanner模拟注册功能
     */
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.println("请输入您的姓名：");
        String name = sc.next();

        System.out.println("请输入您的年龄：");
        int age = sc.nextInt();

        System.out.println("请输入您的性别：");
        String gender = sc.next();

        System.out.println("请输入您的身高：");
        double height = sc.nextDouble();

        System.out.println("请输入您的婚姻状况：");
        boolean flag = sc.nextBoolean();

        System.out.println("注册成功！");
    }
}
