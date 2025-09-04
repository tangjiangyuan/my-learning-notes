package com.java_learn.stream.p3_buffer;

import java.io.BufferedOutputStream;
import java.io.FileOutputStream;
import java.io.IOException;

public class BufferedStreamDemo3 {
    /*
        字节缓冲输出流，写入数据的过程
            - 注意 : 不会直接写入到文件，而是会先写到缓冲流的字节数组中，只有字节大小超过8192，才会写入到文件。
                    但是，关流，会提前将数据写入到文件（即写入的数据不够8192个字节大小，也会写入到文件）。
     */
    public static void main(String[] args) throws IOException {
        BufferedOutputStream bos = new BufferedOutputStream(new FileOutputStream("D:\\d.txt"));
        for (int i = 1; i <= 8192; i++) {
            bos.write(97);
        }
        bos.close();
    }
}
