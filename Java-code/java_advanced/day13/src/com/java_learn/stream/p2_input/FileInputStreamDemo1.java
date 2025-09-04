package com.java_learn.stream.p2_input;

import java.io.FileInputStream;
import java.io.IOException;

public class FileInputStreamDemo1 {
    /*
        字节流读取数据
            --- public int read() : 读取单个字节
     */
    public static void main(String[] args) throws IOException {

        FileInputStream fis = new FileInputStream("D:\\a.txt");

        int i;
        while ((i = fis.read()) != -1) { // 当读取到最后一个元素时，再读取只会返回-1
            System.out.println((char) i); // 将字节转换为字符
        }

        fis.close();
    }
}
