package com.javalearn.demo;

public class SwapDemo {
    /*
        当遇到交换数据时，首先想到交换中介
        int a = 20;
        int b = 10;

        int c = a;
        a = b;
        b = c;
        System.out.println(a);
        System.out.println(b);

        面试题  : 不适用中间变量，如何进行交换
        异或 ^
     */

    /*
        异或^ 特点 :
            1. 相同为false，不同为true
            2. 一个数字，被另一个数字异或两次，该数字不变

        异或操作数值的运算过程：

            1. 将需要运算的数据，转换为二进制数据

                    0000 1010       10
                    0000 0101       5

            2. 将二进制数据的0当作false，1当作true，运算

                    0000 1010
                ^   0000 0101
               ----------------
                    0000 1111

            3. 将运算后的二进制数据，转换为十进制
     */
    public static void main(String[] args) {
        int a = 10;
        int b = 20;

        a = a ^ b;      // a = 10 ^ 20
        b = a ^ b;      // a = 10 ^ 20 ^ 20     b = 10
        a = a ^ b;      // a = 10 ^ 20 ^ 10     a = 20

        System.out.println(a);
        System.out.println(b);
    }
}
