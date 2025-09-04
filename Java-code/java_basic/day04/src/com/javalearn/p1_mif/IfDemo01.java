package com.javalearn.p1_mif;

import java.util.Scanner;

public class IfDemo01 {
    /*
        分支语句（if、switch）
     */
    public static void main(String[] args) {
        //ifTest1();
        //ifTest2();
        ifTest3();
    }

    // if 语句的第一种格式
    /*
        if 语句的第一种格式

            if(判断条件) {
                语句体;
            }

         执行流程：
            1. 执行判断条件，看结果是true，false
            2. true : 执行 {} 中的语句体
            3. false : 不执行 {} 中的语句体
     */
    public static void ifTest1() {
        System.out.println("开始");

        int age = 19;
        if (age > 18){
            System.out.println("可以上网吧！");
        }
        System.out.println("结束");
    }

    // if 语句的第二种格式
    /*
        if() {
            语句1
        } else {
            语句2
        }
     */
    public static void ifTest2() {

        int age = 16;
        if (age > 18){
            System.out.println("可以进入。");
        } else {
            System.out.println("不可以进入！！！");
        }
    }

    // if 语句的第三种格式
    public static void ifTest3() {
        // 需求：键盘录入一个整数数值，表示用户身份       1. 会员   2.非会员   其他，您的输入有误
        Scanner sc = new Scanner(System.in);
        System.out.println("请输入：");
        int num = sc.nextInt();

        if (num == 1){
            System.out.println("会员");
        } else if (num == 2){
            System.out.println("非会员");
        } else {
            System.out.println("您的输入有误");
        }
    }
}
