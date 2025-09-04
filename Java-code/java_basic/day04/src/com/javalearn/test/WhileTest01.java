package com.javalearn.test;

public class WhileTest01 {
    public static void main(String[] args) {
        whileTest();
    }

    /*
        需求；使用while循环，打印水仙花数
     */
    public static void whileTest() {
        int i = 100;
        while (i <= 999) {
            int ge = i % 10;
            int shi = i / 10 % 10;
            int bai = i / 100;
            if (ge * ge * ge + shi * shi * shi + bai * bai * bai == i) {
                System.out.println(i);
            }
            i++;
        }
    }
}
