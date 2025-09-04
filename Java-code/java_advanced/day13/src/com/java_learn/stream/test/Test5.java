package com.java_learn.stream.test;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

public class Test5 {
    /*
        拷贝一个文件夹，包括子文件夹
     */
    public static void main(String[] args) throws IOException{
        File src = new File("D:\\a.txt");
        File dest = new File("E:\\");

        if (src.equals(dest)) {
            System.out.println("目标文件夹是源文件夹的子文件夹");
        } else {
            copyDir(src, dest);
        }
    }

    public static void copyDir(File src, File dest) throws IOException {
        // 重点 ： windows不会自动创建文件夹，只能通过File对象创建
        File newDir = new File(dest, src.getName());
        newDir.mkdirs();

        // 从数据源中获取数据
        File[] files = src.listFiles();
        for (File file : files) { // 文件或文件夹
            // 如果是文件
            if (file.isFile()) {
                // 则直接拷贝
                FileInputStream fis = new FileInputStream(file); // 读取当前文件
                // 重点 ： 写出到目标文件夹下
                FileOutputStream fos = new FileOutputStream(new File(newDir, file.getName()));

                int len;
                byte[] bytes = new byte[1024];
                while ((len = fis.read(bytes)) != -1) {
                    fos.write(bytes, 0, len);
                }

                fis.close();
                fos.close();
            } else { // 如果是文件夹，则递归调用本方法
                copyDir(file, newDir);
            }
        }
    }
}
