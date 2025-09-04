package com.javaLearn.test;

public class OperatorTest02 {
    /*
        看程序说结果
     */
    public static void main(String[] args) {
        int x = 10;
        int y = x++;// y=10,x=11
        int z = ++y;// x=11,z=11,y=11
        System.out.println("x=" + x);
        System.out.println("y=" + y);
        System.out.println("z=" + z);

        System.out.println("-----------------------");

        int a = 3;
        int b = (++a) + (a++) + (a * 10); // 58
        System.out.println("a=" + a);
        System.out.println("b=" + b);
    }
}
