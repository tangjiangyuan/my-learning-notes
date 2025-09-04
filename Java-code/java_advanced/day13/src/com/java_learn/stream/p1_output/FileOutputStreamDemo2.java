package com.java_learn.stream.p1_output;

import java.io.FileOutputStream;
import java.io.IOException;

public class FileOutputStreamDemo2 {
    /*
        演示流对象使用完毕后需要关闭
                    --- 如果不关闭，会占用资源
     */
    public static void main(String[] args) throws IOException {
        FileOutputStream fos = new FileOutputStream("D:\\B.txt");

        fos.write("abc".getBytes());

        fos.close();

        while (true) {}
    }
}
