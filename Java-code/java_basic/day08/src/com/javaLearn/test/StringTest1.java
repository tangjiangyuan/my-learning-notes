package com.javaLearn.test;

import java.util.Scanner;

public class StringTest1 {
    /*
        案例 : 用户登录
        需求 : 已知正确的用户名和密码，请用程序实现模拟用户登录。总共给三次机会，登录之后，给出相应的提示。
     */
    public static void main(String[] args) {
        // 1. 模拟数据库中的信息，定义两个变量用户名和密码
        String username = "张三";
        String password = "1223";
        // 2. 调用 login方法，传参
        login(username, password);
    }

    /**
     * 登录功能
     *
     * @param username
     * @param password
     */
    public static void login(String username, String password) {
        // 3. 定义一个布尔类型的变量，用来和结果比对
        boolean flag = true;
        // 4. 键盘录入用户名和密码
        Scanner sc = new Scanner(System.in);
        // 5. 循环三次
        for (int i = 1; i <= 3; i++) {
            // 6. 模拟登录功能
            System.out.println("----登录----");
            System.out.println("用户名 : ");
            String uname = sc.nextLine();
            System.out.println("密码 : ");
            String pwd = sc.nextLine();
            // 7. 判断
            if (uname.equals(username) && pwd.equals(password)) {
                System.out.println("登录成功 ！");
                break;
            } else {
                if (i == 3) {
                    System.out.println("登录失败，您没有登录次数了。");
                } else {
                    System.out.println("登录失败，您还有" + (3 - i) + "次机会。");
                }
            }
        }
    }
}
