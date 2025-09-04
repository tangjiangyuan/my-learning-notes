package com.javalearn.jdk7.p1_date;

import java.util.Date;

public class DateDemo1 {
    /*
        Date 类：表示时间的类

        1. 构造方法：

                public Date():将当前时间，封装为Date日期对象 (常用)
                public Date(long time):把时间毫秒值转换为Date日期对象

        2. 常见方法：

                public long getTime(): 返回从1970年1月1日 00:00:00 走到此刻的总的毫秒数    (常用)
                public void setTime(long time): 设置日期对象的时间为当前时间毫秒值对应的时间
    */
    public static void main(String[] args) {
        // 将当前时间，封装为Date日期对象
        Date date1 = new Date();
        System.out.println(date1);

        // 把时间毫秒值转换为Date日期对象
        Date date2 = new Date(1000L); // 1000ms
        System.out.println(date2);

        // 返回从1970年1月1日 00:00:00 走到此刻(封装对象时)的总的毫秒数
        System.out.println(date1.getTime());
        System.out.println(date2.getTime());

        // 设置日期对象的时间为当前时间毫秒值对应的时间
        Date date3 = new Date();
        date3.setTime(0L);
        System.out.println(date3);
    }
}
