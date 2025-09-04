package com.javalearn.test;

import java.util.Scanner;

public class IfTest01 {
    /*
        案例：考试奖励
        需求：键盘录入考试成绩，根据成绩所在的区间，程序打印出不同的奖励机制
        95~100：一辆自行车
        90~94：游乐园
        80~89：变形金刚一个
        80以下：挨打
     */
    public static void main(String[] args) {
        scoreAward();
    }

    public static void scoreAward() {

        Scanner sc = new Scanner(System.in);
        System.out.println("请输入您的成绩：");
        int score = sc.nextInt();

        if (score >= 0 && score <= 100) {
            if (score >= 95 && score <= 100) {
                System.out.println("奖励一辆自行车");
            } else if (score >= 90 && score <= 95) {
                System.out.println("奖励去一次游乐园");
            } else if (score >= 80 && score <= 89) {
                System.out.println("奖励一个变形金刚");
            } else {
                System.out.println("挨打！！！");
            }
        } else {
            System.out.println("输入错误");
        }
    }
}
