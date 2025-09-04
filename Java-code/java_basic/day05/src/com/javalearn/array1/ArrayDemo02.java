package com.javalearn.array1;

public class ArrayDemo02 {
    /*
        数组元素访问格式：

            数组名[索引];
            索引 : 数组容器中空间所对应的编号，编号从0开始，逐个+1增长
     */
    public static void main(String[] args) {
        arrayTest();
    }

    public static void arrayTest() {
        int[] arr = {11, 22, 33, 4};

        // 判断数组中第一个元素是奇数还是偶数
        if (arr[0] % 2 == 0) {
            System.out.println(arr[0] + "是偶数");
        } else {
            System.out.println(arr[0] + "是奇数");
        }

        System.out.println("----------------------");

        // 修改数组中第三个元素为66
        arr[2] = 66;
        System.out.println(arr[2]);

        System.out.println("----------------------");

        // 根据数组中第四个元素，决定打印多少次“Hello World”
        for (int i = 1; i <= arr[3]; i++){
            System.out.println("Hello World");
        }
    }
}
