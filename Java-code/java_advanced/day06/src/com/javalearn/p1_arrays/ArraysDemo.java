package com.javalearn.p1_arrays;

import java.util.Arrays;

public class ArraysDemo {
    /*
        Arrays 类常用方法 :
        -----------------------------------------------------------
        public static String toString(类型[] a) : 将数组元素拼接为带有格式的字符串
        public static boolean equals(类型[] a, 类型[] b) : 比较两个数组内容是否相同
        public static int binarySearch(int[] a, int key) : 查找元素在数组中的索引(二分查找 : 保证数组的元素是排好序的!)
                                        - 如果查找的元素，在数组中不存在，返回 (-(插入点) + 1)
        public static void sort(类型[] a) : 对数组进行默认升序排列
        -----------------------------------------------------------
     */
    public static void main(String[] args) {
        int[] arr1 = {11, 22, 33, 44, 55};
        int[] arr2 = {11, 22, 33, 44, 22};

        System.out.println(Arrays.toString(arr1)); // [11, 22, 33, 44, 55]
        System.out.println(Arrays.equals(arr1, arr2)); // false
        System.out.println(Arrays.binarySearch(arr1, 22)); // 1

        int[] arr3 = {55, 33, 44, 11, 22};
        Arrays.sort(arr3);
        for (int i = 0; i < arr3.length; i++) {
            System.out.println(arr3[i]);
        }
    }
}
