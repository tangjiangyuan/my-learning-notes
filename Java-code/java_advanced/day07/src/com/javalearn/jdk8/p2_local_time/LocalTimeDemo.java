package com.javalearn.jdk8.p2_local_time;

import java.time.LocalTime;

public class LocalTimeDemo {
    public static void main(String[] args) {
        // 获取本地的时间对象
        LocalTime nowTime = LocalTime.now();
        System.out.println(nowTime);
        // 时
        System.out.println(nowTime.getHour());
        // 分
        System.out.println(nowTime.getMinute());
        // 秒
        System.out.println(nowTime.getSecond());
        // 纳秒
        System.out.println(nowTime.getNano());
    }
}
