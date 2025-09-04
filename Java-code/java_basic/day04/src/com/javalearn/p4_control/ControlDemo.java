package com.javalearn.p4_control;

import java.util.Scanner;

public class ControlDemo {
    /*
        无限循环（死循环）
            1. for (;;) {}
            2. while (true) {}
            3. do {} while (true)
     */
    public static void main(String[] args) {
        initMenu();
    }

    // 学生登录系统  （ 1. 添加学生  2. 删除学生  3. 修改学生  4. 查看学生  5.退出）
    public static void initMenu() {
        Scanner sc = new Scanner(System.in);

        lo:
        // 标号：给while循环起名字，break根据标号结束这个循环
        while (true) {
            System.out.println("请输入你的选择：1. 添加学生  2. 删除学生  3. 修改学生  4. 查看学生  5.退出");

            int choice = sc.nextInt();
            switch (choice) {
                case 1:
                    System.out.println("添加学生");
                    break;
                case 2:
                    System.out.println("删除学生");
                    break;
                case 3:
                    System.out.println("修改学生");
                    break;
                case 4:
                    System.out.println("查看学生");
                    break;
                case 5:
                    System.out.println("退出");
                    break lo;
                default:
                    System.out.println("输入错误，请重新输入！");
                    break;
            }
        }

    }
}
