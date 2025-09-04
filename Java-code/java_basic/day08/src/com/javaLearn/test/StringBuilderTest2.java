package com.javaLearn.test;

public class StringBuilderTest2 {
    /*
        需求 :
            定义一个方法，把int数组中的数据按照指定的格式拼接(splicing)成一个字符串返回
            调用该方法，并在控制台输出结果。

            例如 : 数组 int[] arr = {1,2,3};
            执行方法后的输出结果为 : [1, 2, 3]
     */
    public static void main(String[] args) {
        // 1. 定义int数组
        int[] arr = {1, 2, 3};
        // 2. 调用方法，传入数组
        String s = printString(arr);
        System.out.println(s);
    }

    public static String printString(int[] arr) {
        // 3. 通过StringBuilder进行拼接
        StringBuilder sb = new StringBuilder("[");
        // 4. 遍历数组，拿到每一个元素
        for (int i = 0; i < arr.length; i++) {
            if (i == arr.length-1) {
                sb.append(arr[i]).append("]");
            } else {
                sb.append(arr[i]).append(", ");
            }
        }
        // 5. 通过 toString方法，将StringBuilder类型转换为String类型，并返回
         return sb.toString();
    }
}
