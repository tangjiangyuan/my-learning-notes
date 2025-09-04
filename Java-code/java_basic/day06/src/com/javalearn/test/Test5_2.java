package com.javalearn.test;

public class Test5_2 {
    public static void main(String[] args) {

        int[] arr = {11,22,33,44,55,66};

        swapArray(arr);

        for (int i = 0; i < arr.length; i++) {
            System.out.println(arr[i]);
        }
    }

    private static void swapArray(int[] arr) {
        for (int start = 0, end = arr.length-1; start < end; start++, end--){// 定义开始和结束指针，只有 start < end 时才交换
            int temp = arr[start];
            arr[start] = arr[end];
            arr[end] = temp;
        }
    }
}
