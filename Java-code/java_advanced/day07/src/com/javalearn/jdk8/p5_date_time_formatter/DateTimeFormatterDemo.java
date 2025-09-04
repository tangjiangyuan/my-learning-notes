package com.javalearn.jdk8.p5_date_time_formatter;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class DateTimeFormatterDemo {
    /*
        用于时间的格式化和解析：

        1. 对象的获取：

            public static DateTimeFormatter ofPattern(格式) : 获取格式对象

        2. 格式化：

            String format(时间) : 按照指定方式格式化

        3. 解析：

            LocalDateTime.parse("解析字符串", 格式化对象);
            LocalDate.parse("解析字符串", 格式化对象);
            LocalTime.parse("解析字符串", 格式化对象);
    */
    public static void main(String[] args) {

        LocalDateTime nowDateTime = LocalDateTime.now();
        System.out.println("格式化之前:" + nowDateTime);

        // 获取格式化对象
        DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("yyyy年MM月dd日");

        // 格式化
        System.out.println("格式化之后:" + dateTimeFormatter.format(nowDateTime));

        // 解析
        String time = "2003年08月28日";
        System.out.println(LocalDate.parse(time, dateTimeFormatter));

    }
}
