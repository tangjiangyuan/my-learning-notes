package com.javalearn.p2_file;

import java.io.File;
import java.io.IOException;

public class FileDemo2 {
    /*
        路径的写法 ---

            1. 绝对路径 : 从盘符根目录开始，一直到某个具体的文件或文件夹
            2. 相对路径 : 相对于当前项目
     */
    public static void main(String[] args) throws IOException {
        File f1 = new File("src\\com\\javalearn\\p2_file\\a.txt");
        f1.createNewFile();
    }
}
