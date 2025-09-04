package com.javalearn.test;

public class Test4_1 {
    public static void main(String[] args) {

        int[] arr = {19, 28, 37, 44, 50, 19, 19};

        int[] result = checkArrayIndex(50, arr);

        if (result.length == 0) {
            System.out.println("该数组不存在！");
        } else {
            for (int i = 0; i < result.length; i++) {
                System.out.println(result[i]);
            }
        }
    }

    /**
     * 查找元素在数组中的索引位置 -- 考虑重复元素
     * 分析：
     * 存入的索引肯定有多个，而return只能返回一个数据，所以考虑使用数组存放索引，并返回索引数组
     * 初始化索引数组：静态初始化需要知道元素，动态初始化需要知道元素个数，而现在都不知道，索引先遍历要查询数据的数组，得到数组的长度，再动态初始化索引数组
     * 每存入一个索引，存放索引的数组的索引也要自增到下一个索引位置，因此，定义一个变量来增加索引数组的索引位置
     * 返回索引数组
     *
     * @param num
     * @param arr
     * @return
     */

    public static int[] checkArrayIndex(int num, int[] arr) {
        // 1. 获取数组长度，得到装索引数组容器的长度
        int count = 0;
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == num) {
                count++;
            }
        }
        // 2. 动态初始化要存放索引的数组
        int[] result = new int[count];
        // 3. 定义一个变量，存放索引的数组每存入一个索引，就会自增
        int index = 0;
        // 4. 遍历数组
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == num) {
                result[index] = i;
                index++; // 每存入一个索引，+1
            }
        }
        // 5. 返回索引数组
        return result;
    }
}
