package com.javalearn.p5_random;

import java.util.Random;

public class RandomDemo01 {
    // 产生随机数 random
    public static void main(String[] args) {
        randomTest();
    }

    public static void randomTest() {

        Random r = new Random();

        int num1  = r.nextInt(100); // 生成一个 0~99 之间的随机数
        System.out.println(num1);
        int num2 = r.nextInt(100) + 1; // 生成一个 1~100 之间的随机数
        System.out.println(num2);

        System.out.println("----------------------------------");

        // 需求 ： 产生 20~80之间的随机数
        for (int i = 0; i < 20; i++) {
            int num = r.nextInt(61)+20;
            int n1 = r.nextInt(80 - 20 + 1) + 20;
            System.out.println(num);
            System.out.println(n1);
        }

    }
}
