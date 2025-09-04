package com.javalearn.test;

import java.util.Scanner;

public class Test4 {
    /*
        需求 : 设计一个方法，查找元素在数组中的索引位置
        已知一个数组 arr = {19,28,37,46,50};
        键盘录入一个数据，查找该数据在数组中的索引。并在控制台输出找到的索引值。
        如果没有查找到，则输出 -1

        数据在该数组中第一次出现的索引位置

        分析 ：
            1. 键盘录入一个数据
            2. 遍历数组
            3. 比较，如果在，返回该数据在数组中的索引；否则，输出 -1
     */
    public static void main(String[] args) {

        int[] arr = {19, 28, 37, 46, 50};

        Scanner sc = new Scanner(System.in);
        System.out.println("请输入 : ");
        int num = sc.nextInt();

        int index = checkArrayIndex(num, arr);
        System.out.println(num + "在数组中的索引位置是:" + index);
    }

    public static int checkArrayIndex(int num, int[] arr) {
        // 1. 假设要查找的元素，在数组中不存在
        int index = -1;
        // 2. 遍历数组，拿到每一个元素
        for (int i = 0; i < arr.length; i++) {
            // 3. 比较
            if (arr[i] == num) {
                // 4. 找到了，让index变量记录正确索引位置
                index = i;
                break;
            }
        }

        return index;
    }

}
