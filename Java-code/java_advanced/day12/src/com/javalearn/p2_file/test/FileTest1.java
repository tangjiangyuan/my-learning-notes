package com.javalearn.p2_file.test;

import java.io.File;
import java.util.Scanner;

public class FileTest1 {
    /*
        案例 ---
        需求 : 键盘录入一个文件夹路径，如果输入错误就给出提示，并继续录入，直到正确为止
        分析 :
            1. 输入的路径可能不存在
            2. 输入的路径可能是文件路径

            封装为 File对象
                调用 exists() 判断是否存在
                调用 isFile() 判断是否是文件
     */
    public static void main(String[] args) {

        File dirPath = getDirPath();
        System.out.println(dirPath);
    }

    public static File getDirPath() {
        Scanner sc = new Scanner(System.in);
        System.out.println("请输入文件夹路径:");

        while (true) {
            String directorPath = sc.nextLine();
            File file = new File(directorPath);

            if (!file.exists()) {
                System.out.println("您输入的文件夹路径不存在，请重新输入:");
            } else if (file.isFile()) {
                System.out.println("您输入的是一个文件路径，请重新输入文件夹路径:");
            } else { // 存在且不是文件，只能是文件夹(因为计算机中，要么是文件，要么是文件夹)
                return file;
            }
        }
    }
}
