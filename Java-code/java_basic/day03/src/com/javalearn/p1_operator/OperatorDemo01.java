package com.javalearn.p1_operator;

public class OperatorDemo01 {
    /*
        赋值运算符：
            1. 基本赋值运算符
                = ：将等号右侧的数值，赋值给等号左侧的变量
                int num = 10;

            2. 扩展赋值运算符
                += : a += b  --> a = a + b
                -= : a -= b  --> a = a - b
                *= : a *= b  --> a = a * b
                /= : a /= b  --> a = a / b
                %= : a %= b  --> a = a % b

                ----------------------------------------------------
                细节补充：
                    扩展赋值运算符，内部自带强制转换
     */
    public static void main(String[] args) {

        short a = 3;
        a += 1;// s = (short) (s + 1);
        System.out.println(a);

        System.out.println("---------------------------");

        short s = 4;
        s = (short) (s + 1);
        System.out.println(s);
    }
}
