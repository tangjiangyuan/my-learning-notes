package com.javalearn.p3_overload;

public class OverloadDemo01 {
    /*

        方法重载 : 方法名形同，参数不同（个数不同、类型不同、顺序不同）
     */
    public static void main(String[] args) {

        fn(10);
        fn(20.5);
    }

    public static void fn(int a) {

    }

    public static void fn(double b) {

    }
}
