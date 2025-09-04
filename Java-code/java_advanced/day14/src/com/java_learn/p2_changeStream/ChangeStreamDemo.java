package com.java_learn.p2_changeStream;

import java.io.*;

public class ChangeStreamDemo {
    /*
        转换流 按照指定编码格式读写
        构造方法
        InputStreamReader(InputStream in, String CharsetName)
        OutputStreamWriter(OutputStream in, String CharsetName)
        --- 构造方法中也可以不指定编码格式，系统会按照默认的编码格式读写
     */
    public static void main(String[] args) throws IOException {
        OutputStreamWriter osw = new OutputStreamWriter(new FileOutputStream("D:\\Test.txt", true), "GBK");
        osw.write("哈哈");
        osw.close();
    }

    private static void read() throws IOException {
        // ANSI 相当于系统默认的gbk
        InputStreamReader isr = new InputStreamReader(new FileInputStream("D:\\Test.txt"), "gbk");
        int i;
        while ((i = isr.read()) != -1) {
            System.out.println((char) i);
        }
        isr.close();
    }
}
