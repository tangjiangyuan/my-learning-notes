package com.javaLearn.p6_typeConversion;

public class TypeConversionDemo01 {
    /*
        类型转换：
            隐式转换：把一个取值范围小的数值或者变量，赋值给另一个取值范围大的变量。

            强制转换：把一个取值范围大的数据或者变量，赋值给另一个取值范围小的变量，不允许直接赋值。
     */
    public static void main(String[] args) {

        // 隐式转换
        int a = 10;
        double b = a;
        System.out.println(b);

        System.out.println("---------------");

        // 隐式转换
        long c = 123L;
        float d = c;
        System.out.println(d);

        System.out.println("---------------");

        int e = 10;
        double f = 20.0;
        double g = e + f;// 30.0
        System.out.println(g);

        System.out.println("----------------");

        byte aa = 10;
        byte bb = 20;
        int cc = aa + bb;// byte、short、char 进行运算时，会自动提升为 int
        System.out.println(cc);
    }
}
