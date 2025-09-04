package com.javaLearn.test;

public class TypeConversionTest01 {
    /*

        类型转换面试题：下列代码是否存在错误，如果有，请指出说明，并改正

        byte b1 = 3;
        byte b2 = 4;
        byte b3 = b1 + b2;

        修改后：
        byte b1 = 3;
        byte b2 = 4;
        byte b3 = (byte) (b1+b2);
        System.out.println(b3);

        Java存在常量优化机制：在编译的时候（javac）就会将3和4这两个字面量进行运算，产生的字节码文件：byte c = 7;
     */
    public static void main(String[] args) {

        byte b1 = 3;
        byte b2 = 4;
        byte b3 = (byte) (b1+b2);
        System.out.println(b3);

        System.out.println("--------------------");

        byte c = 3 + 4;
        System.out.println(c);
    }
}
