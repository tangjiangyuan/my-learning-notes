package com.javalearn.test;

public class ArrayTest01 {
    public static void main(String[] args) {
        printArray();
    }

    public static void printArray() {
        int[] arr = {1, 2, 3, 4, 5, 6};

        for (int i = 0; i < arr.length; i++) {
            System.out.println(arr[i]);
        }
    }
}
