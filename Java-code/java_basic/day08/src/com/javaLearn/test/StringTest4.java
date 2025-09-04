package com.javaLearn.test;

import java.util.Scanner;

public class StringTest4 {
    /*
        案例 : 敏感词(Sensitive Words)替换
        需求 : 键盘录入一个字符串，如果字符串包含（TMD），则使用***替换
     */
    public static void main(String[] args) {
        // 1. 键盘录入一个字符串
        Scanner sc = new Scanner(System.in);
        System.out.println("请输入:");
        String s = sc.nextLine();
        // 2. 调用方法，将录入的字符串传给该方法
        replaceString(s);

    }

    public static void replaceString(String s) {
        // 3. 替换
        String reString = s.replace("TMD", "***");
        System.out.println(reString);
    }
}
