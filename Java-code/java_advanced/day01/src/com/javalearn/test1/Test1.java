package com.javalearn.test1;

import com.javalearn.utils.ArrayTools;



public class Test1 {
    /*
        案例 --- 数组操作类
        编写一个类 ArrayTools 内部编写三个方法
        1. 从数组中找到最大值
        2. 从数组中找到最小值
        3. 打印出数组中所有的元素，要求格式为 [11,22,33]
     */
    public static void main(String[] args) {

        int[] arr = {11, 22, 33};

        System.out.println(ArrayTools.getMax(arr));
        System.out.println(ArrayTools.getMin(arr));
        ArrayTools.changeSimple(arr);
    }
}
