package com.javalearn.test;

public class Test5 {
    public static void main(String[] args) {

        int[] arr = {11,22,33,44,55,66};

        int[] change = arrayChange(arr);

        for (int i = 0; i < change.length; i++) {
            System.out.println(change[i]);
        }
    }

    /*
        案例 : 数组元素反转
        需求 :
        已知一个数组 arr = {11,22,33,44,55};用程序实现把数组中的元素值交换，
        交换后的数组 arr = {55,44,33,22,11};并在控制台输出交换后的数组元素。
     */

    public static int[] arrayChange(int[] arr){
        // 1.定义一个数组容器，记录反转后的元素
        int[] change = new int[arr.length];
        int index = 0;
        for (int i = arr.length-1; i >= 0; i--) {
            change[index] = arr[i];
            index++;
        }
        // 2. 返回数组容器
        return change;
    }
}
