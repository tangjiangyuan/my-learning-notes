package com.javalearn.array2;

public class ArrayDemo03 {
    /*
        二维数组的动态初始化：
        格式 ： 数据类型[][] 数组名 = new 数据类型[m][n];
        m : 表示有几个一维数组
        n : 表示每个一维数组中有多少个元素
     */
    public static void main(String[] args) {

        // int[][] arr = new int[2][3];

        // 问题 ： 能不能将提前准备好的一维数组，直接存入二维数组中？
        // 回答 ： 可以
        int[] arr1 = {11, 22, 33};
        int[] arr2 = {44, 55, 66};
        int[][] arr = new int[2][3];

        arr[0] = arr1;
        arr[1] = arr2;

        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr[i].length; j++) {
                System.out.println(arr[i][j]);
            }
        }
    }
}
