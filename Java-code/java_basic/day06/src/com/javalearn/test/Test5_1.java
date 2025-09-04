package com.javalearn.test;

public class Test5_1 {
    public static void main(String[] args) {

        int[] arr = {11,22,33,44,55,66};

        /*
            数组交换实际上就是：
                数组第一个元素和倒数第一个：  arr[0]      arr[arr.length-1-0]
                数组第二个元素和倒数第二个：  arr[1]      arr[arr.length-1-1]
                数组第三个元素和倒数第三个：  arr[2]      arr[arr.length-1-2]
                ...
         */
        for (int i = 0; i < arr.length / 2; i++) { // i < arr.length / 2 : /2是为了得到交换的次数
            int temp = arr[i];
            arr[i] = arr[arr.length-1-i];
            arr[arr.length-1-i] = temp;
        }

        for (int i = 0; i < arr.length; i++) {
            System.out.println(arr[i]);
        }
    }
}
