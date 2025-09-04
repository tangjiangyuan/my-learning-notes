package com.javalearn.test;

import java.util.Scanner;

public class ArrayTest04 {
    public static void main(String[] args) {
        int[] arr = {100, 50, 20, 90, 90};
        Scanner sc = new Scanner(System.in);

        ex:
        while (true) {
            System.out.println("选项：");
            System.out.println("1. 找出数组最大值，并打印在控制台");
            System.out.println("2. 找出数组最小值，并打印在控制台");
            System.out.println("3. 求总成绩，并打印在控制台");
            System.out.println("4. 计算出平均值，并打印在控制台");
            System.out.println("5. 统计出低于平均值元素个数");
            System.out.println("6. 退出");
            System.out.println("请选择你要的进行的操作 : ");
            int option = sc.nextInt();

            switch (option) {
                case 1:
                    int max = getMax(arr);
                    System.out.println("最大值为：" + max);
                    System.out.println("-------------------");
                    break;
                case 2:
                    int min = getMin(arr);
                    System.out.println("最小值为：" + min);
                    System.out.println("-------------------");
                    break;
                case 3:
                    int sum = getSum(arr);
                    System.out.println("总成绩为：" + sum);
                    System.out.println("-------------------");
                    break;
                case 4:
                    double ave = getAverage(arr);
                    System.out.println("平均值为：" + ave);
                    System.out.println("-------------------");
                    break;
                case 5:
                    int num = getNum(arr);
                    System.out.println("低于平均值的元素个数有：" + num + "个");
                    System.out.println("-------------------");
                    break;
                case 6:
                    System.out.println("退出");
                    break ex;
                default:
                    System.out.println("输入错误，请重新输入");
                    System.out.println("-------------------");
                    break;
            }
        }

    }

    /*
        需求：
            已知班级学生成绩为： int[] arr = {100,50,20,90,90};
            1. 找出数组最大值，并打印在控制台
            2. 找出数组最小值，并打印在控制台
            3. 求总成绩，并打印在控制台
            4. 计算出平均值，并打印在控制台
            5. 统计出低于平均值元素个数
     */
    /**
     * 1. 找出数组最大值，并打印在控制台
     * @param arr
     * @return
     */
    public static int getMax(int[] arr) {
        int max = arr[0];
        for (int i = 1; i < arr.length; i++) {
            if (arr[i] > max) {
                max = arr[i];
            }
        }
        return max;
    }

    /**
     * 2. 找出数组最小值，并打印在控制台
     * @param arr
     * @return
     */
    public static int getMin(int[] arr) {
        int min = arr[0];
        for (int i = 1; i < arr.length; i++) {
            if (arr[i] < min) {
                min = arr[i];
            }
        }
        return min;
    }

    /**
     * 3. 求总成绩，并打印在控制台
     * @param arr
     * @return
     */
    public static int getSum(int[] arr) {
        int sum = 0;
        for (int i = 0; i < arr.length; i++) {
            sum += arr[i];
        }
        return sum;
    }

    /**
     * 4. 计算出平均值，并打印在控制台
     * @param arr
     * @return
     */
    public static double getAverage(int[] arr) {
        int sum = 0;
        for (int i = 0; i < arr.length; i++) {
            sum += arr[i];
        }
        double ave = (sum * 1.0) / arr.length;// 注意：整数除以整数只能得到整数
        return ave;
    }

    /**
     * 5. 统计出低于平均值元素个数
     * @param arr
     * @return
     */
    public static int getNum(int[] arr) {
        int sum = 0;
        for (int i = 0; i < arr.length; i++) {
            sum += arr[i];
        }
        int ave = sum / arr.length;
        // 定义一个变量，记录低于平均值的元素个数
        int count = 0;
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] < ave) {
                count++;
            }
        }
        return count;
    }
}
