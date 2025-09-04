package com.javalearn.jdk8.p3_local_date_time;

import java.time.LocalDateTime;

public class LocalDateTimeDemo {
    public static void main(String[] args) {
        // 获取当前日期
        LocalDateTime nowDateTime = LocalDateTime.now();
        System.out.println(nowDateTime);
        // 年
        System.out.println(nowDateTime.getYear());
        // 月
        System.out.println(nowDateTime.getMonthValue());
        // 日
        System.out.println(nowDateTime.getDayOfMonth());
        // 时
        System.out.println(nowDateTime.getHour());
        // 分
        System.out.println(nowDateTime.getMinute());
        // 秒
        System.out.println(nowDateTime.getSecond());
        // 纳秒
        System.out.println(nowDateTime.getNano());

        // 日：当年的第几天
        System.out.println(nowDateTime.getDayOfYear());
        // 星期
        System.out.println(nowDateTime.getDayOfWeek());
        System.out.println(nowDateTime.getDayOfWeek().getValue());
        // 月份
        System.out.println(nowDateTime.getMonth());
        System.out.println(nowDateTime.getMonth().getValue());
    }
}
