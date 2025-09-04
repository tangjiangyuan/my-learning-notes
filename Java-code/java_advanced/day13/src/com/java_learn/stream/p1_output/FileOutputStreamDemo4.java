package com.java_learn.stream.p1_output;

import java.io.FileOutputStream;
import java.io.IOException;

public class FileOutputStreamDemo4 {
    /*
        IO 流的异常处理方式 : JDK7版本之后
     */
    public static void main(String[] args) {
        // 会自动关流
        try (FileOutputStream fos = new FileOutputStream("D:\\B.txt")) {
            fos.write("abc".getBytes());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
