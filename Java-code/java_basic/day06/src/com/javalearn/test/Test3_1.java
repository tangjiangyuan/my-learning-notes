package com.javalearn.test;

public class Test3_1 {
    public static void main(String[] args) {
        int[] arr1 = {11,22,33};
        int[] arr2 = {11,22,33};

        boolean flag = checkArrayContent(arr1,arr2);
        if (flag == false) {
            System.out.println("两个数组的长度、内容和顺序不相同！");
        }else {
            System.out.println("两个数组的长度、内容和顺序完全相同。");
        }
    }

    public static boolean checkArrayContent(int[] arr1, int[] arr2){
        // 1. 判断长度
        if (arr1.length != arr2.length) {
            return false;
        }
        // 2. 判断内容
        for (int i = 0; i < arr1.length; i++) {
            if (arr1[i] != arr2[i]) {
                return false;
            }
        }
        // 3. 长度、内容和顺序完全相同
        return true;
    }
}
