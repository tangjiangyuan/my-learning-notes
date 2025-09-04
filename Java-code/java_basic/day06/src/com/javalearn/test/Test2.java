package com.javalearn.test;

public class Test2 {
    /*
        案例 : 数组元素求和
        需求 : 有这样一个数组，元素是 {68,27,95,88,171,996,51,210}
        求出该数组中满足要求的元素和
        要求 : 求和的元素个位和十位都不能是7，并且只能是偶数

        分析 ：
            1. 定义数组
            2. 定义求和变量
            3. 遍历数组，拿到每一个元素
            4. 数值拆分，拿到个位、十位，判断个位和十位不能是7，并且只能是偶数
     */
    public static void main(String[] args) {

        int[] arr = {68, 27, 95, 88, 171, 996, 51, 210};

        int sum = getSum(arr);
        System.out.println("求和结果是：" + sum);
    }

    private static int getSum(int[] arr) {

        // 1. 定义数组

        // 2. 定义求和变量
        int sum = 0;
        // 3. 遍历数组，拿到每一个元素
        for (int i = 0; i < arr.length; i++) {
            // 4. 数值拆分，拿到个位、十位，判断个位和十位不能是7，并且不能是偶数
            int ge = arr[i] % 10;
            int shi = arr[i] / 10 % 10;
            if (ge != 7 && shi != 7 && arr[i] % 2 == 0) {
                sum += arr[i];
            }
        }
        // 5. 返回求和结果
        return sum;
    }

}
