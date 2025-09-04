package com.javaLearn.p6_typeConversion;

public class TypeConversionDemo02 {
    /*

        数据转换 - 强制转换
     */
    public static void main(String[] args) {

        double a = 12.3;
        int b = (int)a;
        System.out.println(b);

        System.out.println("--------------------");

        int c = 10;
        byte d = (byte) c;
        System.out.println(d);

        System.out.println("----------------------");

        int num1 = 130;
        byte num2 = (byte)num1;
        System.out.println(num2);// -126 以补码形式存在
    }
}
