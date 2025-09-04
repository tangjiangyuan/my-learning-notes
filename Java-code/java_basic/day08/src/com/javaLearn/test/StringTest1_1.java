package com.javaLearn.test;

import java.util.Scanner;

public class StringTest1_1 {
    public static void main(String[] args) {
        String username = "admin";
        String password = "1223";
        login(username, password);
    }

    public static void login(String username, String password) {
        Scanner sc = new Scanner(System.in);
        for (int i = 1; i <= 3; i++) {
            System.out.println("---登录---");
            System.out.println("用户名 :");
            String inputUsername = sc.nextLine();
            System.out.println("密码 :");
            String inputPassword = sc.nextLine();

            if (inputUsername.equals(username) && inputPassword.equals(password)) {
                System.out.println("登录成功！");
                break;
            } else {
                if (i == 3) {
                    System.out.println("登录失败，您没有次数了。");
                } else {
                    System.out.println("登录失败，您还剩" + (3 - i) + "次机会！");
                }
            }
        }
    }
}
