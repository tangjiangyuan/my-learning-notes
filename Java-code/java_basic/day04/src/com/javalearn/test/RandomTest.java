package com.javalearn.test;

import java.util.Random;
import java.util.Scanner;

public class RandomTest {
    public static void main(String[] args) {
        gussGame();
    }

    // 案例：实现猜数字小游戏
    public static void gussGame() {
        // 1. 系统产生一个随机数
        Random r = new Random();
        int goalNum = r.nextInt(100) + 1;
        // 2. 用户从键盘输入一个猜数
        Scanner sc = new Scanner(System.in);
        // 3. 循环 判断随机数和猜数是否相等
        guss:
        while (true) {
            System.out.println("请输入：");
            int gussNum = sc.nextInt();
            if (gussNum >= 0 && gussNum <= 100) {
                // 4. 相等，循环结束
                if (goalNum == gussNum) {
                    System.out.println("恭喜您，猜对了！！！");
                    break guss;
                } else if (gussNum > goalNum) { // 5. 不相等，循环继续
                    // 6. 猜大了，提示猜大了
                    System.out.println("抱歉，您猜大了");
                } else {
                    // 7. 猜小了，提示猜小了
                    System.out.println("抱歉，您猜小了");
                }
            } else {
                System.out.println("错误，请重新输入");
            }
        }
    }
}
