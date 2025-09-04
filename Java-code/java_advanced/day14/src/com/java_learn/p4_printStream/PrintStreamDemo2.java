package com.java_learn.p4_printStream;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.PrintStream;
import java.io.UnsupportedEncodingException;

public class PrintStreamDemo2 {
    /*
        PrintStream 基本使用
        1. 创建对象关联文件
            public PrintStream(OutputStream os)
            public PrintStream(File file)
            public PrintStream(File file, String csn)
            public PrintStream(String filePath)
            public PrintStream(String filePath, String csn)
        2. 写出方法
            write() :   写出一个字节，不建议使用，无法原样写入
            print() :   原样写入数据，无换行
            println() : 原样写入数据，带有换行
     */
    public static void main(String[] args) throws FileNotFoundException,
            UnsupportedEncodingException {
        PrintStream ps = new PrintStream(new FileOutputStream("D:\\Test.txt", true));
        ps.println("Hello");
        ps.close();
    }

    private static void method2() throws FileNotFoundException, UnsupportedEncodingException {
        PrintStream ps = new PrintStream("D:\\Test.txt", "gbk");
        ps.println("Hello");
        ps.close();
    }

    private static void method1() throws FileNotFoundException {
        PrintStream ps = new PrintStream("D:\\A.txt");

        // ps.write(97);
        ps.print(97);
        ps.println(97);
        ps.println(90.55);
        ps.println('a');
        ps.println("hh");
        ps.println(true);
        ps.close();
    }
}
