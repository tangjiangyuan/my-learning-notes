package com.java_learn.stream.p3_buffer;

import java.io.*;

public class BufferedStreamDemo1 {
    /*
        字节缓冲流在源代码中内置了字节数组，可以提高读写效率

            字节缓冲输入流 : BufferedInputStream(InputStream in)
            字节缓冲输出流 : BufferedOutputStream(OutputStream out)

            缓冲流 : 39ms
            普通流 : 6369ms
     */
    public static void main(String[] args) throws IOException {

        long start = System.currentTimeMillis();

        FileInputStream fis = new FileInputStream("D:\\猪猪侠.ogg");
        FileOutputStream fos = new FileOutputStream("E:\\猪猪侠2.ogg");
        int i;
        while ((i = fis.read()) != -1) {
            fos.write(i);
        }
        fis.close();
        fos.close();

        long end = System.currentTimeMillis();
        System.out.println(end - start);
    }

    private static void bufferedStreamMethod() throws IOException {
        // 1. 创建字节缓冲输入流
        BufferedInputStream bis = new BufferedInputStream(new FileInputStream("D:\\猪猪侠.ogg"));
        // 2. 创建字节缓冲输出流
        BufferedOutputStream bos = new BufferedOutputStream(new FileOutputStream("E:\\猪猪侠.ogg"));
        // 3. 读写操作
        int i;
        while ( (i = bis.read()) != -1) {
            bos.write(i);
        }
        // 4. 关流
        bis.close();
        bos.close();
    }
}
