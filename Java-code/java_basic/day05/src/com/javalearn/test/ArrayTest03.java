package com.javalearn.test;

public class ArrayTest03 {
    public static void main(String[] args) {
        // 1. 定义数组
        int[] arr = {5, 44, 33, 55, 22};
        int max = getMax(arr);
        System.out.println("最大值是：" + max);
    }

    // 案例 ： 数组遍历 - 求最大值
    // 需求 ： 已知数组元素为 {5,44,33,55,22} 请找出数组中最大值并打印在控制台
    public static int getMax(int[] arr) {
        // 2. 定义一个变量，存放最大值
        int max = arr[0];
        // 3. 遍历数组，拿到所有元素
        for (int i = 1; i < arr.length; i++) {
            // 4. 判断相邻两个元素的大小，大的存入变量，依次类推
            if (arr[i] > max) { // 应该是判断 当前元素 是否大于 max，将较大的值保存到 max 中。
                max = arr[i];
            }
        }
        // 5. 找到最大值，并打印
        return max;
    }
}
