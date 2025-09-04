package com.javalearn.p2_file.test;

import java.io.File;

public class FileTest4 {
    /*
        案例 --- 需求: 键盘录入一个文件夹路径，统计文件夹的大小
     */
    public static void main(String[] args) {
        long size = statisticSizeOfDir(FileTest1.getDirPath());
        System.out.println("该文件夹的大小是:" + size + "byte");
    }

    public static long statisticSizeOfDir(File dir) {
        long size = 0;
        File[] files = dir.listFiles();
        for (File file : files) {
            if (file.isFile()) {
                size += file.length();
            } else {
                if (file.listFiles() != null) {
                    size += statisticSizeOfDir(file); // !!! 需要累加递归后的数据
                }
            }
        }
        return size;
    }
}
