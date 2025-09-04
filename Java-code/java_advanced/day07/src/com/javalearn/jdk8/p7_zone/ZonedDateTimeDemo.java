package com.javalearn.jdk8.p7_zone;

import java.time.ZoneId;
import java.time.ZonedDateTime;

public class ZonedDateTimeDemo {
    /*
        ZonedDateTime 带时区的时间对象 :

            static ZonedDateTime now() : 获取当前时间的 ZoneDateTime对象
            static ZonedDateTime ofXxx() : 获取指定时间的ZoneDateTime对象
            ZonedDateTime withXxx() : 修改时间系列的方法
            ZonedDateTime minusXxx() : 减少时间系列的方法
            ZonedDateTime plusXxx() : 增加时间系列的方法
     */
    public static void main(String[] args) {
        // 获取当前时间的 ZoneDateTime对象
        ZonedDateTime now = ZonedDateTime.now();
        System.out.println(now);
        System.out.println("------------------------");

        // 获取指定时间的ZoneDateTime对象
        ZonedDateTime ofZonedDateTime = ZonedDateTime.of(2003, 8, 28,
                8, 8, 8, 8, ZoneId.systemDefault());
        System.out.println(ofZonedDateTime);
        System.out.println("------------------------");

        // 修改时间系列的方法
        System.out.println(now.withYear(2008));
        System.out.println(now.withMonth(8));
        System.out.println(now.withDayOfMonth(8));
        System.out.println("------------------------");

        // 减少时间系列的方法
        System.out.println(now.minusYears(1));
        System.out.println(now.minusMonths(1));
        System.out.println(now.minusDays(1));
        System.out.println("------------------------");

        // 增加时间系列的方法
        System.out.println(now.plusYears(2));
        System.out.println(now.plusMonths(2));
        System.out.println(now.plusDays(2));
        System.out.println("------------------------");


    }
}
