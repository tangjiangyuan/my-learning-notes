package com.javaLearn.test;

import java.util.Scanner;

public class StringBuilderTest1 {
    /*
        需求 : 键盘接收一个字符串，程序判断(judge)出该字符串是否是对称(symmetry)字符串，并在控制台打印是或不是
                对称字符串 : 123321、111
                非对称字符串 : 123123

        --------------------------------

        String ---> StringBuilder

                String s = "abc";
                StringBuilder sb = new StringBuilder(s);

        StringBuilder ---> String

                sb.toString();
     */
    public static void main(String[] args) {

        // 1. 键盘录入字符串
        Scanner sc = new Scanner(System.in);
        System.out.println("请输入一个字符串:");
        String s = sc.nextLine();

        // 2. 调用方法，再传入参数
        boolean result = checkString2(s);
        System.out.println(result);
    }

    /**
     * 第一种判断反转的方法
     * @param s
     * @return
     */
    public static boolean checkString1(String s) {

        // 3. 根据参数判断
        if (s.length() % 2 == 0) { // 字符个数为偶数时
            String start = s.substring(0, s.length() / 2);
            String end = s.substring(s.length() / 2);

            // 4. StringBuilder中有反转方法
            StringBuilder sb = new StringBuilder(end);
            String resultEnd = sb.reverse().toString();

            if (start.equals(resultEnd)) {
                return true;
            }
        } else { // 奇数
            String start = s.substring(0, (s.length() / 2) + 1);
            String end = s.substring(s.length() / 2);

            StringBuilder sb = new StringBuilder(end);
            String resultEnd = sb.reverse().toString();

            if (start.equals(resultEnd)) {
                return true;
            }
        }
        return false;
    }

    /**
     * 第二种判断反转的方法
     * @param s
     * @return
     */
    public static boolean checkString2(String s) {
        StringBuilder sb = new StringBuilder(s);
        String s1 = sb.reverse().toString();
        if (s.equals(s1)) {
            return true;
        }
        return false;
    }
}
