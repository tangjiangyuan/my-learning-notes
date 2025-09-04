package com.javalearn.array2;

public class ArrayDemo02 {
    /*
         二维数组的遍历
     */
    public static void main(String[] args) {
        int[][] arr = {
                {11, 22, 33},
                {44, 55, 66}
        };
        printArray(arr);
        System.out.println("-----------");

        int result = getSum(arr);
        System.out.println("求和结果是 : " + result);
    }

    /**
     * 遍历并打印二维数组中元素
     * 已知一个二维数组 arr = {{11,22,33},{44,55,66}};
     * 遍历该数组，取出所有元素并打印
     */
    public static void printArray(int[][] arr) {

        // 1. 遍历二维数组，得到一维数组的地址
        for (int i = 0; i < arr.length; i++) {
            // 2. 编列一维数组，得到每一个一维数组的元素
            for (int j = 0; j < arr[i].length; j++) {
                System.out.println(arr[i][j]);
            }
        }

    }

    /**
     * 遍历二维数组并求和
     * 已知一个二维数组 arr = {{11,22,33},{44,55,66}};
     * 对内部存储的元素累加求和，并将结果输出在控制台
     *
     * @param arr
     */
    public static int getSum(int[][] arr) {
        // 1. 定义求和变量
        int sum = 0;
        // 2. 遍历二维数组，得到每一个一维数组
        for (int i = 0; i < arr.length; i++) {
            // 3. 遍历一维数组，得到所有元素
            for (int j = 0; j < arr[i].length; j++) {
                // 4. 累加求和
                sum += arr[i][j];
            }
        }
        // 5. 返回求和结果
        return sum;
    }
}
