package com.java_learn.stream.p4_character.reader;

import java.io.FileReader;
import java.io.IOException;

public class FileReaderDemo1 {
    /*
        FileReader : 用于读取纯文本文件，解决中文乱码问题

            构造方法 :
                1. public FileReader(String fileName) : 字符输入流关联文件，路径以字符串形式给出
                2. public FIleReader(File file) : 字符输入流关联文件，路径以File对象形式给出

            成员方法 :
                1. public int read() : 读取单个字符
                2. public int read(char[] cbuf) : 读取一个字符数组，返回读取到的有效字符个数
     */
    public static void main(String[] args) throws IOException {
        FileReader fr = new FileReader("D:\\A.txt");

        char[] chars = new char[10];
        int len;
        while ((len = fr.read(chars)) != -1) {
            String s = new String(chars, 0, len);
            System.out.println(s);
        }
    }

    private static void method1() throws IOException {
        FileReader fr = new FileReader("D:\\A.txt");

        int i;
        while ((i = fr.read()) != -1) {
            System.out.print((char) i);
        }

        fr.close();
    }
}
