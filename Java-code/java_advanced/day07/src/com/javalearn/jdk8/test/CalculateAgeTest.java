package com.javalearn.jdk8.test;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;
import java.util.Scanner;

public class CalculateAgeTest {
    /*
        需求 ： 键盘录入用户生日，计算出用户的实际年龄
     */
    public static void main(String[] args) {

        // 键盘录入用户生日
        Scanner sc = new Scanner(System.in);
        System.out.println("请输入您的生日:");
        String birthday = sc.next();

        // 获取当前时间
        LocalDate today = LocalDate.now();

        // 将字符串转换为 LocalDate 类型的对象
        LocalDate birthdayDate = LocalDate.parse(birthday, DateTimeFormatter.ofPattern("yyyy-M-d"));

        // 通过 ChronoUnit.YEARS.between(birthdayDate, today) 获取用户实际年龄
        System.out.println("您的实际年龄是:" + ChronoUnit.YEARS.between(birthdayDate, today) + "岁。");

    }
}
