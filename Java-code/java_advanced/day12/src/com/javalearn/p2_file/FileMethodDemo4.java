package com.javalearn.p2_file;

import java.io.File;
import java.io.IOException;

public class FileMethodDemo4 {
    /*
        File 类的创建和删除方法:

            public boolean createNewFile() : 创建文件
            public boolean mkdir() : 创建单级文件夹
            public boolean mkdirs() : 创建多级文件夹
            public boolean delete() : 删除文件或文件夹(不走回收站)
                            - delete 方法删除文件夹，只能删除空的文件夹
     */
    public static void main(String[] args) throws IOException {
        File f1 = new File("D:\\Dev-work\\java_advanced\\day12\\src\\com\\javalearn\\p2_file\\B.txt");
        System.out.println(f1.createNewFile());

        File f2 = new File("D:\\Dev-work\\java_advanced\\day12\\src\\com\\javalearn\\p2_file\\aaa\\bbb\\ccc");
        System.out.println(f2.mkdirs());

        File f3 = new File("D:\\Dev-work\\java_advanced\\day12\\src\\com\\javalearn\\p2_file\\C.txt");
        System.out.println(f3.mkdir());

        System.out.println(f1.delete());
        System.out.println(f2.delete());
    }
}
