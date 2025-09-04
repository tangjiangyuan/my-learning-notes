package com.javalearn.mobject.p6_integer;

public class IntegerMethodDemo {
    /*
        Integer 常用方法 :

            public static String toBinaryString(int i)  : 转二进制
            public static String toOctalString(int i)   : 转八进制
            public static String toHexString(int i)     : 转十六进制
            public static int parseInt(String s)        : 将数字字符串，转换为数字
     */
    public static void main(String[] args) {

        int num1 = 120;
        String s = "123";

        System.out.println(Integer.toBinaryString(num1));
        System.out.println(Integer.toOctalString(num1));
        System.out.println(Integer.toHexString(num1));

        int i = Integer.parseInt(s);
        System.out.println(i);

        System.out.println(Double.parseDouble(s) + 100.0);

    }
}
