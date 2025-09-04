package com.javaLearn.p3_scanner;

import java.util.Scanner;

public class ScannerDemo01 {
    /*
        键盘录入
            常用功能：
                int age = sc.nextInt();                 从键盘录入整数，并使用int类型变量接收
                double height = sc.nextDouble();        从键盘录入小数，并使用double类型变量接收
                boolean flag = sc.nextBoolean();        从键盘录入布尔，并使用boolean类型变量接收
                String name = sc.next();                从键盘录入字符串，并使用String类型变量接收
     */
    public static void main(String[] args) {
        
        Scanner sc = new Scanner(System.in);
        System.out.println("请输入年龄：");
        int age = sc.nextInt();
        System.out.println("你的年龄为："+age+'岁');
    }
}
