package com.java_learn.stream.test;

import java.io.*;

public class Test2 {
    /*
        案例 --- 拷贝文件效率测试
        四种拷贝方式
            1. 普通流单个字节拷贝 47ms
            2. 普通流 + 自定义数组拷贝 0ms
            3. 缓冲流单个字节拷贝 0ms
            4. 缓冲流 + 自定义数组拷贝 15ms

        --- 结论 : 首选 2或 4
     */
    public static void main(String[] args) throws IOException{
        /*FileOutputStream fos = new FileOutputStream("D:\\a.txt");
        for (int i = 1; i <= 10000; i++) {
            fos.write(97);
        }
        fos.close();*/
        long start = System.currentTimeMillis();

        copyMethod4();

        long end = System.currentTimeMillis();
        System.out.println(end - start);
    }

    /**
     * 1. 普通流单个字节拷贝
     */
    public static void copyMethod1() throws IOException {
        FileInputStream fis = new FileInputStream("D:\\a.txt");
        FileOutputStream fos = new FileOutputStream("E:\\a1.txt");
        int i;
        while ((i = fis.read()) != -1) {
            fos.write(i);
        }
        fis.close();
        fos.close();
    }

    /**
     * 2. 普通流 + 自定义数组拷贝
     */
    public static void copyMethod2() throws IOException{
        FileInputStream fis = new FileInputStream("D:\\a.txt");
        FileOutputStream fos = new FileOutputStream("E:\\a2.txt");
        int len;
        byte[] bys = new byte[1024];
        while ((len = fis.read(bys)) != -1) {
            fos.write(bys, 0, len);
        }
        fis.close();
        fos.close();
    }

    /**
     * 3. 缓冲流单个字节拷贝
     */
    public static void copyMethod3() throws IOException{
        BufferedInputStream bis = new BufferedInputStream(new FileInputStream("D:\\a.txt"));
        BufferedOutputStream bos = new BufferedOutputStream(new FileOutputStream("E:\\a3.txt"));
        int i;
        while ((i = bis.read()) != -1) {
            bos.write(i);
        }
        bis.close();
        bos.close();
    }

    /**
     * 4. 缓冲流 + 自定义数组拷贝
     */
    public static void copyMethod4() throws IOException{
        BufferedInputStream bis = new BufferedInputStream(new FileInputStream("D:\\a.txt"));
        BufferedOutputStream bos = new BufferedOutputStream(new FileOutputStream("E:\\a4.txt"));
        int len;
        byte[] bys = new byte[1024]; // 或者8192
        while ((len = bis.read(bys)) != -1) {
            bos.write(bys, 0, len);
        }
        bis.close();
        bos.close();
    }
}
