package com.javalearn.jdk8.p4_update;

import java.time.LocalDate;
import java.time.LocalDateTime;

public class UpdateDemo {
    public static void main(String[] args) {
        LocalDateTime nowDateTime = LocalDateTime.now();
        // 当前时间
        System.out.println(nowDateTime);
        // minus : 减去
        // minusYears(年) minusMonths(月) minusDays(日) minusWeeks(周) minusHours(时) minusMinutes(分) minusSeconds(秒) minusNanos(纳秒)
        System.out.println("减一小时:" + nowDateTime.minusHours(1));
        System.out.println("减一分钟:" + nowDateTime.minusMinutes(1));
        System.out.println("减一秒钟:" + nowDateTime.minusSeconds(1));
        System.out.println("减一纳秒:" + nowDateTime.minusNanos(1));
        System.out.println("对比时间，确定方法返回的都是新的实例 >>>" + nowDateTime);

        System.out.println("------------------------------");

        // plus : 加
        // plusYears(年) plusMonths(月) plusDays(日) plusWeeks(周) plusHours(时) plusMinutes(分) plusSeconds(秒) plusNanos(纳秒)
        System.out.println("加一小时:" + nowDateTime.plusHours(1));
        System.out.println("加一分钟:" + nowDateTime.plusMinutes(1));
        System.out.println("加一秒钟:" + nowDateTime.plusSeconds(1));
        System.out.println("加一纳秒:" + nowDateTime.plusNanos(1));

        System.out.println("------------------------------");

        // with : 这里体现的是，设置效果
        System.out.println("修改的效果:");
        // withYear(年) withMonth(月) withDayOfMonth(日) withHour(时) withMinute(分) withSecond(秒) withNana(纳秒)
        System.out.println(nowDateTime.withYear(2003));
        System.out.println(nowDateTime.withMonth(8));
        System.out.println(nowDateTime.withDayOfMonth(28));
        System.out.println(nowDateTime.withHour(8));
        System.out.println(nowDateTime.withMinute(8));
        System.out.println(nowDateTime.withNano(8));

        System.out.println("------------------------------");

        LocalDate ofDate = LocalDate.of(2003, 8, 28);
        LocalDate nowDate = LocalDate.now();

        // 2003-08-28 是否在nowDate之前?
        System.out.println(ofDate + "是否在" + nowDate + "之前？" + ofDate.isBefore(nowDate));

        // 2003-08-28 是否在nowDate之后?
        System.out.println(ofDate + "是否在" + nowDate + "之后？" + ofDate.isAfter(nowDate));

        System.out.println("------------------------------");

        // 判断两个时间是否相等
        System.out.println(ofDate.equals(nowDate));
    }
}
