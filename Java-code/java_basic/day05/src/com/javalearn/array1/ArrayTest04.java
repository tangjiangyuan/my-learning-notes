package com.javalearn.array1;

import java.util.Random;
import java.util.Scanner;

public class ArrayTest04 {
    public static void main(String[] args) {
        // 1. 键盘录入5个学生成绩，找出最高分
        /*int[] arrayScanner = initArrayFromScanner();
        int max = getMax(arrayScanner);
        System.out.println("最高分是:" + max);*/

        // 2. 产生10个1~100之间的随机数，找出最小值
        int[] arrayRandom = initArrayFromRandom();
        int min = getMin(arrayRandom);
        System.out.println("最小值是:" + min);

    }

    private static int[] initArrayFromRandom() {
        int[] arrayRandom = new int[10];
        Random r = new Random();
        for (int i = 0; i < arrayRandom.length; i++) {
            arrayRandom[i] = r.nextInt(100) + 1;
            System.out.println(arrayRandom[i]);
        }
        return arrayRandom;
    }

    private static int[] initArrayFromScanner() {
        int[] arrayScanner = new int[5];
        Scanner sc = new Scanner(System.in);
        System.out.println("请输入5个学生成绩");
        for (int i = 0; i < arrayScanner.length; i++) {
            System.out.println("请输入第" + (i + 1) + "个学生的成绩:");
            arrayScanner[i] = sc.nextInt();
        }
        return arrayScanner;
    }

    public static int getMax(int[] arr) {
        int max = arr[0];
        for (int i = 1; i < arr.length; i++) {
            if (arr[i] > max) {
                max = arr[i];
            }
        }
        return max;
    }

    public static int getMin(int[] arr) {
        int min = arr[0];
        for (int i = 1; i < arr.length; i++) {
            if (arr[i] < min) {
                min = arr[i];
            }
        }
        return min;
    }
}
