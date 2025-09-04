package com.javalearn.p2_file;

import java.io.File;

public class FileMethodDemo5 {
    /*
        File 类的遍历方法 :
            public File[] listFiles() : 获取当前目录下所有的 “一级文件对象”，返回 File数组
     */
    public static void main(String[] args) {
        File f1 = new File("D:\\Dev-work\\java_advanced\\day12\\src\\com\\javalearn\\p2_file");
        File[] files = f1.listFiles();
        for (File file : files) {
            System.out.println(file);
        }
    }
}
