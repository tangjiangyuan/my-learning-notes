package com.javalearn.jdk8.p1_local_date;

import java.time.LocalDate;

public class LocalDateDemo {
    public static void main(String[] args) {
        // 获取本地日期
        LocalDate nowDate = LocalDate.now();
        System.out.println(nowDate);
        // 年
        System.out.println(nowDate.getYear());
        // 月
        System.out.println(nowDate.getMonthValue());
        // 日
        System.out.println(nowDate.getDayOfMonth());

        // 日：当年中的第几天
        System.out.println(nowDate.getDayOfYear());
        // 星期
        System.out.println(nowDate.getDayOfWeek());
        System.out.println(nowDate.getDayOfWeek().getValue());
        // 月份
        System.out.println(nowDate.getMonth());
        System.out.println(nowDate.getMonth().getValue());
    }
}
