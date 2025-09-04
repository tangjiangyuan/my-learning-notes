package com.javalearn.jdk8.p7_zone;

import java.time.Instant;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.util.Set;

public class ZonedIdDemo {
    /*
        ZoneId : 时区类

        常见方法 :

            1. static Set<String> getAvailableZoneIds() : 获取 Java中支持的所有时区
            2. static ZoneId systemDefault() : 获取系统默认时区
            3. static ZoneId of(String zoneId) : 获取一个指定时区
     */
    public static void main(String[] args) {
        // 获取 Java中支持的所有时区
        Set<String> availableZoneIds = ZoneId.getAvailableZoneIds();
        System.out.println(availableZoneIds);
        System.out.println(availableZoneIds.size());

        System.out.println("-------------------------");

        // 获取系统默认时区
        ZoneId zoneId = ZoneId.systemDefault();
        System.out.println(zoneId);

        System.out.println("-------------------------");

        // 获取一个指定时区
        ZoneId of = ZoneId.of("America/Marigot");
        System.out.println(of);

        ZonedDateTime zonedDateTime = Instant.now().atZone(of);
        System.out.println(zonedDateTime);

    }
}
