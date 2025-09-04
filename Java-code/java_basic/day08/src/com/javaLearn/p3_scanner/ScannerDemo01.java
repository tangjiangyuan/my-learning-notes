package com.javaLearn.p3_scanner;

import java.util.Scanner;

public class ScannerDemo01 {
    /*
        Scanner 键盘录入字符串 :

            String next() : 遇到了空格，或者是tab键就不再录入了。
            String nextLine() : 可以解决遇到空格或者是tab键不可继续录入的情况。以回车作为录入结束（下班）的标记。

            弊端 :
                    1. next() : 数据可能录入不完整。
                    2. nextLine() : 之前调用过nextInt(),nextDouble()...,nextLine()方法，就不执行了。

            解决方案 : 不需要解决
                    Scanner : 采集用户信息（只在学习过程中用得到）

            目前的使用方案 :
                    需求如果要键盘录入字符串
                            如果所有的数据，全部都是字符串，直接nextLine();
                                举例 :
                                        键盘录入用户名，键盘录入用户密码

                            如果数据除了字符串，还有其他类型，需要调用next()方法
                                举例 :
                                        键盘录入用户名，键盘录入用户年龄，用户身高
     */
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        /*System.out.println("请输入:");
        String name = sc.next();
        System.out.println(name);*/

        System.out.println("----------------");

        System.out.println("请输入:");
        String name1 = sc.nextLine();
        System.out.println(name1);
    }
}
