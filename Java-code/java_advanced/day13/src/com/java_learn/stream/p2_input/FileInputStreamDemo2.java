package com.java_learn.stream.p2_input;

import java.io.FileInputStream;
import java.io.IOException;

public class FileInputStreamDemo2 {
    /*
        字节流读取数据
            --- public int read(byte[] bys) : 读取一个字节数组
            将读取到的字节，存入数组容器，返回读取到的有效字节个数

            String 类的构造方法
            --- public String(byte[] bytes, int offset, int length) : 将字符数组装换为字符串
                    - 参数1 : 字符数组
                    - 参数2 : 起始索引
                    - 参数3 : 转换个数
     */
    public static void main(String[] args) throws IOException {

        FileInputStream fis = new FileInputStream("D:\\a.txt");

        // 准备字节数组，装字节
        byte[] bys = new byte[2];

        int len;
        while ((len = fis.read(bys)) != -1) {
            String s = new String(bys, 0, len);
            System.out.print(s);
        }

        fis.close();

    }
}
