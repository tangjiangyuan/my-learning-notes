package com.java_learn.stream.test;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

public class Test1 {
    /*
        案例 --- 文件拷贝
        将 D:\\嘿嘿.png，拷贝到 E:\\ 根目录下
        1. 创建输入流对象读取文件
        2. 创建输出流对象关联到数据目的地
        3. 读写操作
        4. 关流释放内存
     */
    public static void main(String[] args) throws IOException {
        // 1. 创建输入流对象读取文件
        FileInputStream fis = new FileInputStream("D:\\嘿嘿.png");
        // 2. 创建输出流对象关联到数据目的地
        FileOutputStream fos = new FileOutputStream("E:\\嘿嘿.png");
        // 3. 读写操作
        byte[] bys = new byte[1024]; // 将需要读取的数据存放入字节数组中
        int len; // 有效字节数
        while ((len = fis.read(bys)) != -1) {
            fos.write(bys, 0, len); // 有效字节数为多少，就读多少
        }
        // 4. 关流释放内存
        fis.close();
        fos.close();
    }
}
