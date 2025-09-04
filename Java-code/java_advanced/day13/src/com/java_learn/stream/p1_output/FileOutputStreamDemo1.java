package com.java_learn.stream.p1_output;

import java.io.FileOutputStream;
import java.io.IOException;

public class FileOutputStreamDemo1 {
    /*
        字节流写出数据

            构造方法:
                1. public FileOutputStream(String name) : 输出流关联文件，文件路径以字符串形式给出
                2. public FileOutputStream(File file) : 输出流关联文件，文件路径以 File对象给出

            成员方法:
                public void write(int i) : 写出一个字节
                public void write(byte[] bys) : 写出一个字节数组

            细节:
                输出流关联文件，文件如果不存在 : 会自动创建出来；
                                - 如果文件存在 : 会清空所有的内容，然后再进行写入操作
     */
    public static void main(String[] args) throws IOException {
        // 输出流关联文件，文件路径以字符串形式给出
        // true : 表示开启追加写入模式
        FileOutputStream fos = new FileOutputStream("D:\\a.txt", true);
        // 写出数据
        fos.write(97);
        fos.write(98);
        fos.write(99);

        byte[] bys = {99, 100, 101, 102};
        fos.write(bys);
        fos.write("你好你好".getBytes()); // 将文字输入到文件中
        fos.write(bys, 1, 3); // 字节数组、起始索引、写入个数

        fos.close();
    }
}
