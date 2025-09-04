package com.javaLearn.p3_dataType;

public class DataTypeDemo01 {
    /*
        数据类型：

            1.基本数据类型

                    整数
                        byte                1个字节        -128~127
                        short               2个字节        -2^15~2^15-1
                        int                 4个字节        -2^31~2^31-1
                        long                8个字节        -2^63~2^63-1
                    小数
                        float(单精度)        4个字节
                        double(双精度)       8个字节
                    字符
                        char                2个字节        0~65535
                    布尔
                        boolean             1个字节

            2.应用数据类型

                数组、类、接口

            ------------------------------------------------------------
            使用思路：
                1.整数类型：首选 int，如果发现 int装不下，将类型换成long，定义long类型变量需要加入L的标识
                2.小数类型：首选double，非要用float类型，需要加入F表示
     */
    public static void main(String[] args) {
        // 1.整数类型：首选 int，如果发现 int装不下，将类型换成long，定义long类型变量需要加入L的标识
        int num = 1233333333; // int 只能放10位 -2147483648~2147483647
        long num1 = 12333111111L;

        // 2.小数类型：首选double，非要用float类型，需要加入F表示
        double height = 183.1;
        float height1 = 183.1f;

        char gender = '男';
        boolean result = true;
    }
}
