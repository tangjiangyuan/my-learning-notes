package com.javaLearn.test;

import java.util.Scanner;

public class StringTest3 {
    /*
        案例 : 手机号屏蔽(shield)
        需求 : 以字符串的形式从键盘接受一个手机号，将中间四位号码屏蔽
        最终效果为 : 156****1234
     */
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.println("请输入手机号:");
        String s = sc.nextLine();

        if (s.length() == 11) {
            shieldPhoneNumber(s);
        } else {
            System.out.println("抱歉，输入错误！！！");
        }
    }

    public static void shieldPhoneNumber(String num) {
        // 1. 取出需要不需要隐藏的字符
        String shieldStartNum = num.substring(0, 3);
        String shieldEndNum = num.substring(7, 11);
        // 2. 拼接
        System.out.println(shieldStartNum + "****" + shieldEndNum);
    }
}
