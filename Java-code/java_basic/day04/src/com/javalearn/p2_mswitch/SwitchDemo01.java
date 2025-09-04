package com.javalearn.p2_mswitch;

import java.util.Scanner;

public class SwitchDemo01 {
    /*

        分支语句 -- switch
     */
    public static void main(String[] args) {
        // switchTest1();
        switchTest2();
    }

    public static void switchTest1() {
        Scanner sc = new Scanner(System.in);
        System.out.println("请输入：");
        int num = sc.nextInt();

        switch (num) {
            case 1:
                System.out.println("星期一");
                break;
            case 2:
                System.out.println("星期二");
                break;
            case 3:
                System.out.println("星期三");
                break;
            case 4:
                System.out.println("星期四");
                break;
            case 5:
                System.out.println("星期五");
                break;
            case 6:
                System.out.println("星期六");
                break;
            case 7:
                System.out.println("星期天");
                break;
            default:
                System.out.println("输入错误");
                break;
        }
    }

    // case 穿透现象
    // 需求：键盘录入一个数值，1~5：输出工作日；6~7：输出休息日
    public static void switchTest2() {
        Scanner sc = new Scanner(System.in);
        System.out.println("请输入一个整数：");
        int week = sc.nextInt();

        switch (week) {
            case 1:
            case 2:
            case 3:
            case 4:
            case 5:
                System.out.println("工作日");
                break;
            case 6:
            case 7:
                System.out.println("休息日");
                break;
            default:
                System.out.println("您输入的数据有误");
                break;
        }
    }
}
