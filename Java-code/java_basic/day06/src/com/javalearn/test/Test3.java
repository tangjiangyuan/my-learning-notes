package com.javalearn.test;

import java.util.Scanner;

public class Test3 {
    /*
        案例 : 判断两个数组元素是否相同
        需求 : 定义一个方法，用于比较两个数组的内容是否相同
        要求 : 长度，内容，顺序完全相同

        分析 ：
            1. 得到数组的长度 数组名.length
            2. 判断数组的内容 遍历两个数组，拿到每一个元素
            3. 顺序
     */
    public static void main(String[] args) {
        int[] arr1 = {11, 22, 33, 44, 70};
        int[] arr2 = {55, 66, 77, 88, 70};

        compareArray(arr1, arr2);
    }

    public static void compareArray(int[] arr1, int[] arr2) {

        Scanner sc = new Scanner(System.in);

        loop:
        while (true) {
            System.out.println("--------------------------------------");
            System.out.println("选项");
            System.out.println("1. 查看两个数组的长度是否相同");
            System.out.println("2. 查看两个数组的内容是否相同");
            System.out.println("3. 查看两个数组的长度、内容和顺序是否相同");
            System.out.println("4. 退出");
            System.out.println("--------------------------------------");
            System.out.println("请选择你的操作：");

            int option = sc.nextInt();

            switch (option) {
                case 1:
                    checkLength(arr1, arr2); // 1. 查看两个数组的长度是否相同
                    break;
                case 2:
                    checkContext(arr1, arr2); // 2. 查看两个数组的内容是否相同
                    break;
                case 3:
                    boolean flag = checkOdder(arr1, arr2); // 3. 查看两个数组的长度、内容和顺序是否相同
                    if (flag == true) {
                        System.out.println("两个数组的长度、内容和顺序相同");
                    }else {
                        System.out.println("两个数组的长度、内容和顺序不相同");
                    }
                    break;
                case 4:
                    System.out.println("结束");
                    break loop;
                default:
                    System.out.println("输入错误，请重新输入！");
                    break;
            }
        }
    }

    // 查看长度
    public static void checkLength(int[] arr1, int[] arr2) {
        if (arr1.length == arr2.length) {
            System.out.println("两个数组的长度相同。");
        } else {
            System.out.println("两个数组的长度不相同！！！");
        }
    }

    // 查看内容
    public static void checkContext(int[] arr1, int[] arr2) {
        int[][] array = new int[2][];
        array[0] = arr1;
        array[1] = arr2;
        for (int i = 0; i < arr1.length; i++) {
            if (array[0][i] == array[1][i]) {
                System.out.println("array[0][" + i + "]:" + array[0][i] + "和" + "array[1][" + i + "]:" + array[1][i] + "相同。");
            } else {
                System.out.println("array[0][" + i + "]:" + array[0][i] + "和" + "array[1][" + i + "]:" + array[1][i] + "不相同！");
            }
        }
    }

    // 查看顺序
    public static boolean checkOdder(int[] arr1, int[] arr2) {

        // 长度
        if (arr1.length != arr2.length) {
            return false;
        }

        // 内容
        for (int i = 0; i < arr1.length; i++) {
            if (arr1[i] != arr2[i]) {
                return false;
            }
        }

        // 完全相同
        return true;
    }
}
