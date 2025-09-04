package com.javalearn.jdk8.p6_instant;

import java.time.Instant;
import java.time.ZoneId;
import java.time.ZonedDateTime;

public class InstantDemo2 {
    /*
        Instant 类常见方法 :

            static Instant now() : 获取当前时间的 Instant对象（标准时间）
            static Instant ofXxx(long epochMilli) : 根据（秒/毫秒/纳秒）获取 Instant对象
            ZonedDateTime atZone(ZoneId zone) : 指定时区
            boolean isXxx(Instant otherInstant) : 判断系列的方法
            Instant minusXxx(long millisToSubtract) : 减少时间系列的方法
            Instant plusXxx(long millisToSubtract) : 增加时间系列的方法
     */
    public static void main(String[] args) {
        // 获取当前时间的 Instant对象（标准时间）
        Instant now = Instant.now();
        System.out.println("当前时间（世界标准时间）:" + now);

        System.out.println("---------------");

        // 根据（秒/毫秒/纳秒）获取 Instant对象
        Instant instant1 = Instant.ofEpochMilli(1000);
        Instant instant2 = Instant.ofEpochMilli(5);
        System.out.println(instant1);
        System.out.println(instant2);
        System.out.println("---------------");

        // 指定时区
        ZonedDateTime zonedDateTime = Instant.now().atZone(ZoneId.of("America/Marigot"));
        System.out.println("带时区的时间:" + zonedDateTime);
        System.out.println("---------------");

        // 判断系列的方法
        System.out.println(now.isBefore(instant1));
        System.out.println(now.isAfter(instant2));
        System.out.println("---------------");

        // 减少时间系列的方法
        System.out.println("减1000毫秒:" + now.minusMillis(1000));
        System.out.println("减5秒钟:" + now.minusSeconds(5));
        System.out.println("---------------");

        // 增加时间系列的方法
        System.out.println("加1000毫秒:" + now.plusMillis(1000));
        System.out.println("加5秒钟:" + now.plusSeconds(5));
        System.out.println("---------------");
    }
}
