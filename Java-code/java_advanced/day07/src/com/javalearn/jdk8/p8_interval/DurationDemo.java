package com.javalearn.jdk8.p8_interval;

import java.time.Duration;
import java.time.LocalDateTime;

/**
 * Duration 计算日期间隔（时分秒）
 */
public class DurationDemo {
    public static void main(String[] args) {
        // 此刻日期时间对象
        LocalDateTime today = LocalDateTime.now();
        System.out.println(today);

        // 昨天的日期时间对象
        LocalDateTime otherDate = LocalDateTime.of(2025, 3, 10, 0, 0, 0);
        System.out.println(otherDate);

        Duration duration = Duration.between(otherDate, today); // 第二个参数减第一个参数

        System.out.println(duration.toDays());      // 两个时间差的天数
        System.out.println(duration.toHours());     // 两个时间差的小时数
        System.out.println(duration.toMinutes());   // 两个时间差的分钟数
        System.out.println(duration.toMillis());    // 两个时间差的毫秒数
        System.out.println(duration.toNanos());     // 两个时间差的纳秒数
    }
}
