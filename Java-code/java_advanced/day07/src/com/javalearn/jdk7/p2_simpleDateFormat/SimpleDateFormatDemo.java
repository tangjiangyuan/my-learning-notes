package com.javalearn.jdk7.p2_simpleDateFormat;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class SimpleDateFormatDemo {
    /*
        SimpleDateFormat类：用于日期格式化

        1. 构造方法：

                public SimpleDateFormat(): 创建一个日期格式化对象，使用[默认模式]
                public SimpleDateFormat(String pattern): 创建一个日期格式化对象，[手动指定模式]

        2. 常用方法：

                public final String format(Date date): 将日期对象，转换为字符串
                public final Date parse(String source): 将日期字符串，解析为日期类型 (字符串和指定格式的模式要一致才能匹配)
     */
    public static void main(String[] args) throws ParseException {
        String today = "2025年3月10日";
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy年MM月dd日");
        System.out.println(simpleDateFormat.parse(today));

        method();
    }

    private static void method() {
        // 创建一个日期格式化对象，使用[默认模式]
        // SimpleDateFormat simpleDateFormat = new SimpleDateFormat();

        // 创建一个日期格式化对象，[手动指定模式]
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy年MM月dd日 HH:mm:ss E a");
        // 将此刻时间封装为对象
        Date date = new Date();
        System.out.println(simpleDateFormat.format(date));
    }
}
