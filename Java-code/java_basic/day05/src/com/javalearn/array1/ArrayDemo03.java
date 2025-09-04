package com.javalearn.array1;

public class ArrayDemo03 {
    public static void main(String[] args) {
        arrayTest1();
    }

    /*
        数组的动态初始化

        默认值：
            整数 : 0
            小数 : 0.0
            布尔 : false
            -----------
            字符 : '\u0000'       ---> Unicode码表 ---> 常见的体现是空白字符
            引用数据类型 : null
     */
    public static void arrayTest1() {
        int[] arr = new int[5];// 定义了一个数组，数组中有5个元素
        for (int i = 0; i < arr.length; i++) {
            System.out.println(arr[i]);
        }
    }
}
