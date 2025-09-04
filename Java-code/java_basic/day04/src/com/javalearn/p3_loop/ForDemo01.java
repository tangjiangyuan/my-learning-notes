package com.javalearn.p3_loop;

public class ForDemo01 {
    /*
        循环 -- for
        for 循环语句格式：

            for(初始化语句 ;判断条件 ;条件控制语句 ) {
                循环语句体;
            }
     */
    public static void main(String[] args) {
        forTest2();
        System.out.println("-----------------");
        printTriangle();
        System.out.println("-------------------");
        forTest3();
    }

    public static void forTest1() {
        for (int i = 1; i <= 3; i++) {
            System.out.println("跑圈");
        }
    }

    // 打印一个四行五列的*型矩阵
    public static void forTest2() {
        // 四行五列
        for (int i = 1; i <= 4; i++) {// 行
            for (int j = 1; j <= 5; j++) {// 列
                System.out.print("*");
            }
            System.out.println();// 换行
        }
    }

    // 打印一个5行的*型的直角三角形
    /*
        需求： 在控制台使用 * 打印5行的直角三角形
        *
        **
        ***
        ****
        *****
     */
    public static void printTriangle() {
        for (int i = 1; i <= 5; i++) {
//            for (int j = 1; j <= i; j++) {
//                System.out.print("*");
//            }
            for (int j = 0; j <= 5 - i; j++) {
                System.out.print(" ");
            }
            for (int k = 0; k < i; k++) {
                System.out.print("*");
            }
            System.out.println();
        }
    }

    // 打印九九乘法表
    public static void forTest3() {
        // 外循环控制行
        for (int i = 1; i <= 9; i++) {
            // 内循环控制列
            for (int j = 1; j <= i; j++) {
                int num = i * j;
                System.out.print(j + "*" + i + "=" + num + "\t");
            }
            System.out.println();
        }
    }
}
