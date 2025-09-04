package com.java_learn.p1_buffered;

import java.io.*;

public class BufferedStreamDemo1 {
    /*
        字符缓冲流的基本使用:
            注意 --- 缓冲流本身不具备读写共功能，只是对普通流对象做包装
            构造方法 :
                BufferedReader(Reader reader)
                BufferedWriter(Writer writer)
     */
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new FileReader("D:\\A.txt"));
        BufferedWriter bw = new BufferedWriter(new FileWriter("D:\\B.txt"));

        int len;
        char[] chs = new char[1024];
        while ((len = br.read(chs)) != -1) {
            bw.write(chs, 0, len);
        }
        br.close();
        bw.close();
    }

    private static void method1() throws IOException {
        BufferedReader br = new BufferedReader(new FileReader("D:\\A.txt"));
        BufferedWriter bw = new BufferedWriter(new FileWriter("D:\\B.txt"));

        int i;
        while ((i = br.read()) != -1) {
            bw.write(i);
        }
        br.close();
        bw.close();
    }
}
