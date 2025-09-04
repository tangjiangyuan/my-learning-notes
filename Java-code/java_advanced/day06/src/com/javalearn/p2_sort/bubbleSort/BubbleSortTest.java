package com.javalearn.p2_sort.bubbleSort;

import java.util.Arrays;

public class BubbleSortTest {
    public static void main(String[] args) {
        int[] arr = {99, 2, 11, 50, 44};
        System.out.println(Arrays.toString(bubbleSort(arr)));
    }

    public static int[] bubbleSort(int[] arr) {
        for (int i = 0; i < arr.length - 1; i++) { // 外循环：控制比较轮数
            for (int j = 0; j < arr.length - 1 - i; j++) { // 内循环：控制比较次数
                if (arr[j] > arr[j + 1]) {
                    int temp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = temp;
                }
            }
        }
        return arr;
    }
}
