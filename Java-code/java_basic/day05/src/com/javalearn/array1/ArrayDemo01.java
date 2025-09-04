package com.javalearn.array1;

public class ArrayDemo01 {
    /*
        数组

        定义格式：
            1. 数据类型[] 数组名;  （常用）

            2. 数据类型 数组名[];
     */
    public static void main(String[] args) {
        arrayTest2();
    }

    // 数组定义格式
    public static void arrayTest1() {
        int[] array;
        int array2[];
    }

    // 数组静态初始化
    /*
        格式：
            完整格式：
                数据类型[] 数组名 = new 数据类型[]{e1,e2,e3...en};

            简化格式：
                数据类型[] 数组名 = {e1,e2,e3...en};

            打印数组名
                [I@1eb44e46

                @ ： 分隔符
                [ ： 当前这个空间，是数组类型的
                I : 当前数组类型，是int类型
                1eb44e46 : 数组的十六进制内存地址
     */
    public static void arrayTest2() {

        int[] a1 = new int[]{1, 3, 5, 7, 9};
        System.out.println(a1);
        int[] a2 = {2, 4, 6, 8, 10};
        System.out.println(a2);
    }
}
