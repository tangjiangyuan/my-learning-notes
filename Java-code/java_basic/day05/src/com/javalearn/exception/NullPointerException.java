package com.javalearn.exception;

public class NullPointerException {
    public static void main(String[] args) {

        int[] arr = {11,222,33};

        arr = null;

        System.out.println(arr[1]);
    }
}
