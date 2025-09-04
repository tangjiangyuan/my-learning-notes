package com.javalearn.array2;

public class ArrayDemo01 {
    public static void main(String[] args) {

        // 1. 完整格式：
        int[][] arr1 = new int[][]{{11, 22, 33}, {44, 55, 66}, {77, 88, 99}};

        // 2. 简化格式：
        int[][] arr2 = {
                {11, 22, 33},
                {44, 55, 66}
        };

        // 注意 : 二维数组在存储一维数组时，存储的是一维数组的地址值。
        System.out.println(arr2); // [[I@1eb44e46
        System.out.println(arr2[0]); // [I@6504e3b2
        System.out.println(arr2[1]); // [I@515f550a

        /*
            二维数组的元素访问格式：

                    数组名[m索引][n索引] :

                    m索引 : 指定访问哪一个一维数组
                    n索引 : 访问一维数组中哪一个元素

         */
    }
}
