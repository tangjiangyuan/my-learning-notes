package com.javalearn.jdk8;

import java.time.LocalDateTime;

public class Demo {
    /*
        -----------------------------------------------
        LocalDate、LocalTime、LocalDateTime

        对象创建方式：

        1. now(): 设置时间
        2. of(...): 设置时间

        -----------------------------------------------
        LocalDateTime 转换 LocalDate,LocalTime

        1. toLocalDate()
        2. toLocalTime()
     */
    public static void main(String[] args) {
        // 获取此刻时间对象
        LocalDateTime now = LocalDateTime.now();
        System.out.println(now);

        System.out.println(now.toLocalDate());
        System.out.println(now.toLocalTime());

        System.out.println(now.getYear() + "年");
        System.out.println(now.getMonth() + "月");
        System.out.println(now.getMonthValue() + "月");
        System.out.println(now.getDayOfMonth() + "日");
        System.out.println(now.getHour() + "时");
        System.out.println(now.getMinute() + "分");
        System.out.println(now.getSecond() + "秒");
        System.out.println(now.getNano() + "纳秒");

        // 获取指定时间对象
        LocalDateTime of = LocalDateTime.of(2008, 8, 8, 8, 8);
        System.out.println(of);
    }
}
