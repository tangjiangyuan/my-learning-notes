package com.javalearn.p2_sort.binarySearch;

import java.util.Arrays;
import java.util.Scanner;

public class BinarySearchDemo {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        int[] arr = {22, 33, 88, 11, 66, 77, 99, 44, 100, 55};
        System.out.println("请输入您要查找的元素:");
        int num = sc.nextInt();

        // 得到排好序的数组
        int[] arrSort = bubbleSort(arr);

        int index = binarySearch(arrSort, num);

        if (index == -1) {
            System.out.println("元素:" + num + "不在数组中！");
        } else {
            System.out.println("元素:" + num + "在数组中的索引是:" + index + "。");
        }
    }

    /**
     * 冒泡排序
     *
     * @param arr
     * @return
     */
    public static int[] bubbleSort(int[] arr) {
        for (int i = 0; i < arr.length - 1; i++) {
            for (int j = 0; j < arr.length - 1 - i; j++) {
                if (arr[j] > arr[j + 1]) {
                    int temp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = temp;
                }
            }
        }
        System.out.println(Arrays.toString(arr));
        return arr;
    }

    /**
     * 选择排序
     *
     * @param arr
     * @return
     */
    public static int[] selectSort(int[] arr) {
        for (int i = 0; i < arr.length - 1; i++) {
            for (int j = i + 1; j < arr.length; j++) {
                if (arr[i] > arr[j]) {
                    int temp = arr[i];
                    arr[i] = arr[j];
                    arr[j] = temp;
                }
            }
        }
        return arr;
    }

    /**
     * 二分查找
     */
    public static int binarySearch(int[] arrSort, int num) {

        int min = 0, max = arrSort.length - 1;
        int middle;

        while (min <= max) { // 避免越界
            middle = (max + min) / 2;
            if (num == arrSort[middle]) {
                return middle;
            } else if (num < arrSort[middle]) {
                max = middle - 1;
            } else {
                min = middle + 1;
            }
        }
        return -1;
    }
}
