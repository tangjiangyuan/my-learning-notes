package com.java_learn.stream.p1_output;

import java.io.FileOutputStream;
import java.io.IOException;

public class FileOutputStreamDemo3 {
    /*
        Io流的异常处理方式 : JDK7版本之前
     */
    public static void main(String[] args) throws IOException {
        FileOutputStream fos = null;
        try {
            // System.out.println(10 / 0);
            fos = new FileOutputStream("D:\\B.txt");
            fos.write("abc".getBytes());
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (fos != null) { // fos不为null，表示和流建立联系了，需要关流
                fos.close();
            }
        }
    }
}
