package com.javalearn.test;

import java.util.Scanner;

public class Test6_1 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("请输入参赛选手的人数:");
        int competeNum = sc.nextInt();
        System.out.println("请输入评委人数:");
        int peoNum = sc.nextInt();

        for (int i = 1; i <= competeNum; i++) {
            int[] arr = new int[peoNum]; // 记录评委打分的数组

            for (int j = 0; j < arr.length; j++) {
                System.out.println("请输入第" + i + "个参赛选手中第" + (j + 1) + "个评委的打分:");

                int score = sc.nextInt();
                if (score >= 0 && score <= 100){
                    arr[j] = score;
                }else {
                    System.out.println("打分错误，请重新输入！！！");
                    i--;
                }
            }
            double avg = getAvg(peoNum, arr);
            System.out.println("第"+i+"位选手的最后得分为:" + avg);
        }

    }

    public static double getAvg(int num, int[] arr) {
        double max = getMax(arr);
        double min = getMin(arr);
        double sum = 0;
        for (int i = 0; i < arr.length; i++) {
            sum += arr[i];
        }
        double avg = (sum - max - min) / ((num - 2) * 1.0);
        return avg;
    }

    public static double getMax(int[] arr) {
        double max = arr[0];
        for (int i = 1; i < arr.length; i++) {
            if (arr[i] > max) {
                max = arr[i];
            }
        }
        return max;
    }

    public static double getMin(int[] arr) {
        double min = arr[0];
        for (int i = 1; i < arr.length; i++) {
            if (arr[i] < min) {
                min = arr[i];
            }
        }
        return min;
    }
}
