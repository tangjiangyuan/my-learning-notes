package com.javalearn.mobject.p6_integer;

public class IntegerTest {
    /*
        包装类练习
        已知字符串 String s = "10, 50, 30, 20, 40";
        请将该字符串转换为整数并存入数组
        随后求出最大值打印在控制台
     */
    public static void main(String[] args) {
        String s = "10,50,30,20,40";

        String[] split = s.split(",");
        int[] nums = new int[split.length];
        for (int i = 0; i < split.length; i++) {
            nums[i] = Integer.parseInt(split[i]);
        }
        int max = getMax(nums);
        System.out.println("最大值是:" + max);


    }
    public static int getMax(int[] arr) {
        int max = arr[0];
        for (int i = 1; i < arr.length; i++) {
            max = Math.max(max, arr[i]);
        }
        return max;
    }
}
