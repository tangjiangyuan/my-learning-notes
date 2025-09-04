package com.javalearn.p1_operator;

public class OperatorDemo03 {
    /*
        逻辑运算符
            &(与) : 并且。全true，则true；遇false，则false。
            |(或) : 或者。一true，则true；全false，则false。
            !(非) : 取反。
            ^(异或) : 相同的为false，不同的为true。
     */
    public static void main(String[] args) {
        // &
        System.out.println(true & true);
        System.out.println(true & false);
        System.out.println(false & true);
        System.out.println(false & false);

        System.out.println("---------------------");

        // |
        System.out.println(true | true);
        System.out.println(true | false);
        System.out.println(false | true);
        System.out.println(false | false);

        System.out.println("---------------------");

        // !
        System.out.println(!true);
        System.out.println(!false);

        System.out.println("---------------------");

        // ^
        System.out.println(true ^ true);
        System.out.println(true ^ false);
        System.out.println(false ^ true);
        System.out.println(false ^ false);
    }
}
