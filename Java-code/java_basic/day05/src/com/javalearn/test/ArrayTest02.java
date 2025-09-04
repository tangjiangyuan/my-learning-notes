package com.javalearn.test;

public class ArrayTest02 {
    public static void main(String[] args) {
        // 1. 定义数组
        int[] arr = {11, 22, 33, 44, 55};
        int result = arrayTest(arr);
        System.out.println("求和结果是：" + result);
    }

    // 案例 ：数组遍历 - 求偶数(even)和. 奇数(odd)
    // 需求 ： 已知数组元素为 {11,22,33,44,55} 请将数组中偶数元素取出并求和，最后打印求和结果
    public static int arrayTest(int[] arr) {

        // 2. 定义一个变量，接收求和的结果
        int sum = 0;
        // 3. 遍历数组
        for (int i = 0; i < arr.length; i++) {
            // 4. 判断偶数
            if (arr[i] % 2 == 0) {
                // 5. 求和
                sum += arr[i];
            }
        }
        // 6. 返回变量结果
        return sum;
    }
}
