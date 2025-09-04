package com.java_learn.p4_printStream;

import java.io.PrintStream;
import java.util.Scanner;

public class PrintStreamDemo1 {
    /*
        System.out.println(); 打印语句的细节
        "标准"输出流 --- 写出到控制台
     */
    public static void main(String[] args) {
        PrintStream out = System.out; // 打印流也是一个字节流
        out.println("哈哈");

        // System.out --- "标准"输出流
        System.out.println();
        // System.in --- "标准"输入流
        Scanner sc = new Scanner(System.in);
        // System.err --- "标准"错误输出流
        System.err.println("哈哈");
    }
}
