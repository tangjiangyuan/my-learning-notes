package com.java_learn.p4_printStream;

import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

public class PrintWriterDemo {
    /*
        字符打印流 PrintWriter
     */
    public static void main(String[] args) throws IOException {
        PrintWriter pw = new PrintWriter(new FileWriter("D:\\Test.txt"), true);
        pw.println("Hello");
    }

    private static void method1() throws FileNotFoundException {
        PrintWriter pw = new PrintWriter("D:\\Test.txt");
        // 字符流需要关流或调用 flush()，数据才会写出;字节流不需要
        pw.println("Hello");
        pw.close();
    }
}
