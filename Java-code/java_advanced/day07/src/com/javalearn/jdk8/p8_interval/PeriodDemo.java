package com.javalearn.jdk8.p8_interval;

import java.time.LocalDate;
import java.time.Period;

/**
 * Period计算日期间隔（年月日）
 */
public class PeriodDemo {
    public static void main(String[] args) {
        // 此刻年月日
        LocalDate today = LocalDate.now();
        System.out.println(today);

        // 昨天年月日
        LocalDate otherDate = LocalDate.of(2025, 3, 10);
        System.out.println(otherDate);

        // Period 对象表示时间的间隔对象
        Period period = Period.between(today, otherDate); // 第二个参数减第一个参数

        System.out.println(period.getYears());          // 间隔多少年
        System.out.println(period.getMonths());         // 间隔的月份
        System.out.println(period.getDays());           // 间隔的天数
        System.out.println(period.toTotalMonths());     // 总月份

    }
}
