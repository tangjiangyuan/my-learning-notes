package com.javalearn.p2_sort.bubbleSort;

import java.util.Arrays;

public class BubbleSortDemo {
    /*
        冒泡排序 : 相邻的两个数进行比较，如果第一个比第二个大，就交换他们两个

        有5个数据时
        第一轮：arr[0]-arr[1]  arr[1]-arr[2]  arr[2]-arr[3]  arr[3]-arr[4]  比较4(4-0)次
        第二轮：arr[0]-arr[1]  arr[1]-arr[2]  arr[2]-arr[3]  比较3(4-1)次
        第三轮：arr[0]-arr[1]  arr[1]-arr[2]  比较2(4-2)次
        第四轮：arr[0]-arr[1]  比较1(4-3)次
     */
    public static void main(String[] args) {
        int[] arr = {11, 33, 22, 55, 44};

        // 外循环 比较轮数
        for (int i = 0; i < arr.length - 1; i++) { // i = 0 1 2 3
            // 内循环 比较次数
            // -1：避免索引越界
            // -i: 提高效率，减少次数
            for (int j = 0; j < arr.length - 1 - i; j++) { // j = 0 1 2 3
                if (arr[j] > arr[j + 1]) {
                    int temp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = temp;
                }
            }
        }
        System.out.println(Arrays.toString(arr));
    }
}
