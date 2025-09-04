package com.javalearn.jdk7.p3_calendar;

import java.util.Calendar;

public class CalendarDemo {
    /*
        calendar : 代表的是系统此刻时间对应的日历，通过它可以单独获取、修改时间中的年、月、日、时、分、秒等。

        1. 创建对象:
                public static Calendar getInstance() : 获取当前时间的日历对象

        2. 常用方法:
                public int get(int field):  取日历中的某个信息

                        get方法的参数 : Calendar类中的静态常量
                        c.get(Calendar.YEAR) : 获取年
                        c.get(Calendar.MONTH) : 获取月,月份范围为[0~11]
                        c.get(Calendar.DAY_OF_MONTH) : 获取日
                        c.get(Calendar.DAY_OF_WEEK) : 获取周
                        c.get(Calendar.HOUR) : 获取小时(12小时制)
                        c.get(Calendar.HOUR_OF_DAY) : 获取小时(24小时制)
                        c.get(Calendar.MINUTE) : 获取分钟


                public void set(int field, int value):  修改日历的某个字段信息
                public void add(int field, int amount): 为某个字段增加/减少指定的值
     */
    public static void main(String[] args) {

    }

    private static void addMethod() {
        Calendar calendar = Calendar.getInstance();
        calendar.add(Calendar.YEAR, 1);
        System.out.println(calendar.get(Calendar.YEAR));
    }

    private static void setMethod() {
        Calendar c = Calendar.getInstance();
        c.set(Calendar.YEAR, 2022);
        System.out.println(c.get(Calendar.YEAR));
    }

    private static void getMethod() {
        // Calendar c : 抽象类
        // Calendar.getInstance() : 获取的是子类对象
        // 1. 获取当前时间的日历对象
        Calendar c = Calendar.getInstance();

        // 2. 调用get方法，取日历中的某个信息
        System.out.println(c.get(Calendar.YEAR) + "年");
        // 注意Calendar类的月份时 0~11，想要获取正常的月份，需要对结果 +1操作
        System.out.println(c.get(Calendar.MONTH) + 1 + "月"); // 月份范围为[0~11]
        System.out.println(c.get(Calendar.DAY_OF_MONTH) + "日");

        // 星期  : 日  一   二   三   四   五   六   (国外星期)
        //        1   2    3    4    5   6    7
        char[] weeks = {' ', '日', '一', '二', '三', '四', '五', '六'};
        //               0    1     2    3     4     5    6     7
        // 根据索引索取中国的星期
        // int weekIndex = c.get(Calendar.DAY_OF_WEEK);
        // System.out.println("星期" + weeks[weekIndex]);
        System.out.println("星期" + weeks[c.get(Calendar.DAY_OF_WEEK)]);

        // System.out.println(c.get(Calendar.HOUR)); // 12小时制
        System.out.println(c.get(Calendar.HOUR_OF_DAY)); // 24小时制
        System.out.println(c.get(Calendar.MINUTE));
    }
}
