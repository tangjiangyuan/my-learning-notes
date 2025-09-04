package com.javalearn.p3_loop;

public class WhileDemo01 {
    // 循环语句 -- while
    public static void main(String[] args) {
        whileTest1();
    }

    public static void whileTest1() {
        for (int i = 1; i <= 5; i++) {
            System.out.println("i love u");
        }

        System.out.println("------------------");

        int i = 1;
        while (i <= 5) {
            System.out.println("i love u");
            i++;
        }
    }
}
