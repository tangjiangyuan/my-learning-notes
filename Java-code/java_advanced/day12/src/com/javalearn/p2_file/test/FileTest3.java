package com.javalearn.p2_file.test;

import java.io.File;

public class FileTest3 {
    /*
        案例 ---
        需求 : 设计一个方法，删除文件夹
        注意 : delete() 只能删除空文件夹
            *** delete() 的删除不走回收站，不要拿重要的数据测试！！！
     */
    public static void main(String[] args) {
        deleteDirector(new File("D:\\text"));
    }

    public static void deleteDirector(File dir) {
        // 1. 获取所有的文件或文件夹对象
        File[] files = dir.listFiles();
        // 2. 遍历数组，获取每一个文件或文件夹对象
        for (File file : files) {
            if (file.isFile()) {
                // 文件直接删
                file.delete();
            } else {
                // 文件夹的话，需要进入文件夹继续删除
                if (file.listFiles() != null) {
                    deleteDirector(file); // 递归
                }
            }
        }
        // 循环结束后，删除文件夹
        dir.delete();
    }
}
