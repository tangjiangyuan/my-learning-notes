package com.javalearn.p2_file.test;

import java.io.File;

public class FileTest2 {
    /*
        需求 --- 键盘录入一个文件夹路径，找出这个文件夹下的所有的 .java文件
     */
    public static void main(String[] args) {
        File dir = FileTest1.getDirPath();

        printJavaFiles(dir);
    }

    /**
     * 对接收到的文件夹路径进行遍历，找出所有的 .java文件
     * @param dir 获取文件夹路径
     */
    public static void printJavaFiles(File dir) {
        // 1. 获取当前路径下所有的文件或文件夹对象
        File[] files = dir.listFiles();
        // 2. 对数组遍历，获取每一个文件或文件夹对象
        for (File file : files) {
            // 3. 判断是否是 .java文件
            if (file.isFile() && file.getName().endsWith(".java")) {
                System.out.println(file);
            } else if (file.isDirectory()) { // 如果是文件夹，就进入这个文件夹。即调用方法本身
                if (file.listFiles() != null) { // 避免文件夹为空，出现的空指针异常
                    printJavaFiles(file);
                }
            }
        }
    }

    private static void method(File dir) {
        // 获取当前路径下所有的文件或文件夹对象
        File[] files = dir.listFiles();
        // 遍历数组，获取每一个文件或文件夹对象
        for (File file : files) {
            // 判断是否是文件，并且文件的后缀需要 .java结尾
            if (file.isFile() && file.getName().endsWith(".java")) {
                System.out.println(file);
            }
        }
    }
}
