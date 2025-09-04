package com.javalearn.jdk7.test;

import java.util.Calendar;

public class Test2 {
    /*
        案例 : 疯狂星期四
        需求 : 使用程序判断出 2050年3月1日是否是疯狂星期四
     */
    public static void main(String[] args) {
        Calendar c = Calendar.getInstance();
        char[] weeks = {' ', '日', '一', '二', '三', '四', '五', '六'};

        c.set(Calendar.YEAR, 2050);
        c.set(Calendar.MONTH, 3);
        c.set(Calendar.DAY_OF_MONTH, 7);

        // c.set(2050, 2, 1); // 月份[0~11]

        int weekIndex = c.get(Calendar.DAY_OF_WEEK);
        if (weekIndex == 5) {
            System.out.println("是疯狂星期四！！！");
        } else {
            System.out.println("不是疯狂星期四。");
        }
    }
}
