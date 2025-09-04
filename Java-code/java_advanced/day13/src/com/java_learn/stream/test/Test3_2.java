package com.java_learn.stream.test;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;

public class Test3_2 {
    /*
        注意 : 一个数连续异或两次得到的还是原数
        加密 : 运行一次
        解密 : 运行两次
     */
    public static void main(String[] args) throws IOException {
        // 1. 创建输入流对象，关联到要加密的图片
        FileInputStream fis = new FileInputStream("D:\\a.jpg");
        // 2. 创建一个Integer类型的集合，来存放读取到的字节
        ArrayList<Integer> list = new ArrayList<>();
        // 3. 循环读取文件中的字节，并存入集合
        int i;
        if ((i = fis.read()) != -1) {
            list.add(i);
        }
        // 4. 关闭输入流对象
        fis.close();

        // 5. 创建输出流对象，关联到图片文件
        FileOutputStream fos = new FileOutputStream("D:\\a.jpg");
        // 6. 遍历集合，从集合中取出字节，并写出
        for (Integer myByte : list) {
            fos.write(myByte ^ 2); // 在调用一次相当于 myByte ^ 2 ^ 2
        }
        // 7. 关闭输出流对象
        fos.close();
    }
}
