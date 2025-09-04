package com.java_learn.stream.p4_character.reader;

import java.io.FileInputStream;
import java.io.IOException;

public class FileInputStreamDemo {
    /*
        使用字节流读取纯文本文件
            - 若文件中只有汉字，通过字节数组读取没有问题
                但是如果文件中不仅有汉字，还有标点符号，也会出现乱码
     */
    public static void main(String[] args) throws IOException {
        FileInputStream fis = new FileInputStream("D:\\A.txt");

        int i;
        while ((i = fis.read()) != -1) {
            System.out.println((char) i);
        }

        fis.close();
    }
}
