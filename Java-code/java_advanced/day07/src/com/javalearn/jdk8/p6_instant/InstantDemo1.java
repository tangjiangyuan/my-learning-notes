package com.javalearn.jdk8.p6_instant;

import java.time.Instant;
import java.time.ZoneId;
import java.time.ZonedDateTime;

public class InstantDemo1 {
    /*
        Instant 类 : 用于表示时间的对象，类似之前所学习的 Date
     */
    public static void main(String[] args) {
        // 存在时差
        Instant now = Instant.now();
        System.out.println("当前时间戳:" + now);

        ZonedDateTime zonedDateTime = Instant.now().atZone(ZoneId.of("Asia/Shanghai"));
        System.out.println(zonedDateTime);
    }
}
