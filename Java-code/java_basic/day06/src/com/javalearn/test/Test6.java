package com.javalearn.test;

import java.util.Scanner;

public class Test6 {
    /*
        案例 : 评委打分
        需求 : 在编程竞赛中，有6个评委为参赛的选手打分，分数为0-100
        选手的最后得分为 : 去掉一个最高分和一个最低分后 的4个评委平均值

        分析 :
        1. 先考虑只有一个选手的情况，Scanner键盘录入6个评委的打分，存入一个数组中
        2. 定义两个方法，得到最高分和最低分
        3. 计算最终得分
     */
    public static void main(String[] args) {
        initData();
    }

    /**
     * 此方法用来初始化数据并获得平均值
     */
    private static void initData() {
        System.out.println("---评委打分---");
        // 1. 键盘录入评委人数
        Scanner sc = new Scanner(System.in);
        System.out.println("请输入评委人数:");
        int peoNum = sc.nextInt();
        // 2. 动态初始化存放评委打分的数组
        int[] arr = new int[peoNum]; // 记录评委打分的数组
        // 3. 遍历数组
        for (int i = 0; i < arr.length; i++) {
            System.out.println("请输入第" + (i + 1) + "位评委的打分:");
            // 4. 定义一个变量接收评分
            int score = sc.nextInt();
            // 5. 判断评分是否符合条件
            if (score >= 0 && score <= 100) { // 注意：分数应该在 0-100之间
                // 6. 符合条件，将评分存入数组
                arr[i] = score;
            } else {
                // 7. 不符合，给出提示，并 i--;回到上一次打分
                System.out.println("打分错误，请重新输入！！！");
                i--; // 细节!!!
            }
        }
        // 8. 调用getAvg方法，并定义avg变量接收得到的平均值，最后打印
        double avg = getAvg(peoNum, arr);
        System.out.println("该选手的最后得分为:" + avg);
    }

    // 计算最终得分
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

    // 获取最大值
    public static double getMax(int[] arr) {
        double max = arr[0];
        for (int i = 1; i < arr.length; i++) {
            if (arr[i] > max) {
                max = arr[i];
            }
        }
        return max;
    }

    // 获取最小值
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
