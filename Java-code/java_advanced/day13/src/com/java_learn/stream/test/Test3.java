package com.java_learn.stream.test;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;

public class Test3 {
    /*
        例一 图片文件加密和解密
        加密思路 ： 改变原始文件中的字节，就无法打开了
                字节^2
        解密思路： 将文件中的字节还原成原始字节即可
                字节^2
        注意 : 一个数连续异或两次得到的还是原数
        加密 : 运行一次
        解密 : 运行两次
     */
    public static void main(String[] args) throws Exception{
        method();
    }


    public static void method() throws IOException{
        FileInputStream fis = new FileInputStream("D:\\a.png");
        ArrayList<Integer> list = new ArrayList<>();
        int i;
        if ((i = fis.read()) != -1) {
            list.add(i);
        }
        fis.close();

        FileOutputStream fos = new FileOutputStream("D:\\a.png");
        for (Integer myByte : list) {
            fos.write(myByte ^ 2);
        }
        fos.close();
    }
}
