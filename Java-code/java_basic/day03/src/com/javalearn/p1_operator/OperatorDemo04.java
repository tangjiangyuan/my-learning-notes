package com.javalearn.p1_operator;

public class OperatorDemo04 {
    /*
        短路逻辑运算符：
            & ：没有短路效果，无论左边是true，false，右边都要执行
            && ：具有短路效果，左边为false，右边不执行；左边为true，右边要继续执行。
            | ：没有短路效果，无论左边是true，false，右边都要执行
            || ：具有短路效果，左边为true，右边不执行；左边为false，右边要继续执行。
     */
    public static void main(String[] args) {

        int x = 3;
        int y = 4;
        //boolean result = ++x > 5 & y-- < 4;  // x=4,y=3,result=false
        boolean result = ++x > 5 && y-- < 4;   // x=4,y=4,result=false

        System.out.println(x);
        System.out.println(y);
        System.out.println(result);
    }
}
