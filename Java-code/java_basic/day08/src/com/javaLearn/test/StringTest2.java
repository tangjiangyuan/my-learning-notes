package com.javaLearn.test;

import java.util.Scanner;

public class StringTest2 {
    /*
        案例 : 统计字符次数
        需求 : 键盘录入一个字符串，统计该字符串中大写字母字符，小写字母字符，数字字符出现的次数（不考虑其他字符）
        例如 : aAb3&c2B*4CD1
        小写字母 : 3个
        大写字母 : 4个
        数字字符 : 4个
     */
    public static void main(String[] args) {
        // 1. 键盘录入一个字符串
        Scanner sc = new Scanner(System.in);
        System.out.println("请输入一个字符串:");
        String s = sc.nextLine();
        // 2. 调用统计字符次数方法，并将字符串传给该方法
        statisticsCharNum(s);
    }

    /**
     * 统计字符串中字符个数
     * @param s 传的参数（字符串）
     */
    public static void statisticsCharNum(String s) {
        // 3. 定义三个变量，接收小写字母个数、大写字母个数，以及数字字符个数
        int lowercaseNum = 0;
        int uppercaseNum = 0;
        int number = 0;
        // 4. 拿到该字符串后，遍历
        char[] chars = s.toCharArray();
        for (int i = 0; i < chars.length; i++) {
            if (chars[i] >= 'a' && chars[i] <= 'z') {
                lowercaseNum++;
            } else if (chars[i] >= 'A' && chars[i] <= 'Z') {
                uppercaseNum++;
            } else if (chars[i] >= '0' && chars[i] <= '9') {
                number++;
            }
        }
        System.out.println("小写字母个数:" + lowercaseNum + "个");
        System.out.println("大写字母个数:" + uppercaseNum + "个");
        System.out.println("数字字符个数:" + number + "个");
    }
}
