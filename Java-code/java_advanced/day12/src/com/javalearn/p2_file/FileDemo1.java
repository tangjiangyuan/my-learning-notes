package com.javalearn.p2_file;

import java.io.File;
import java.io.IOException;

public class FileDemo1 {
    /*
        File 类介绍 --- 文件或文件夹对象
        构造方法 ---
            1. public File(String pathname) : 根据传入的字符串路径封装 File对象
            2. public File(String parent, String child) : 根据传入的父路径和子路径来封装 File对象
            3. public File(File parent, String child) : 根据传入的父路径(File类型)和子路径来封装 File对象
     */
    public static void main(String[] args) throws IOException {
        // method1
        File f1 = new File("D:\\a.text");
        // f1.createNewFile();
        System.out.println(f1);

        File f2 = new File("D:\\text");
        System.out.println(f2.exists());

        // method2
        File f3 = new File("D:\\", "a.txt");
        System.out.println(f3.exists());

        // method3
        File f4 = new File(new File("D:\\"), "a.txt");
        System.out.println(f4.exists());
    }
}
