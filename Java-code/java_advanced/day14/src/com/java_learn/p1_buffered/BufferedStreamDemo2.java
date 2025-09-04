package com.java_learn.p1_buffered;

import java.io.*;

public class BufferedStreamDemo2 {
    /*
        字符缓冲流的特有方法:
            public String readLine() : 读取一行字符串，读取到末尾返回null
            public void newLine() : 写出换行符(具有跨平台性)
     */
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new FileReader("D:\\C.txt"));
        BufferedWriter bw = new BufferedWriter(new FileWriter("D:\\D.txt"));

        String line;
        // readLine读完一行后会识别到换行符，但是不会打印出来，因此不具备换行功能
        while ((line = br.readLine()) != null) {
            bw.write(line);
            bw.newLine();
        }
        br.close();
        bw.close();
    }

    // 优化 --- 使用循环读取
    private static void method2() throws IOException {
        BufferedReader br = new BufferedReader(new FileReader("D:\\C.txt"));

        String line;
        while ((line = br.readLine()) != null) {
            System.out.println(line);
        }
        br.close();
    }

    // 原始 --- 一行一行读取
    private static void method1() throws IOException {
        BufferedReader br = new BufferedReader(new FileReader("D:\\C.txt"));

        String s1 = br.readLine();
        String s2 = br.readLine();

        System.out.println(s1);
        System.out.println(s2);
        br.close();
    }
}
