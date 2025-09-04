package com.javalearn.jdk7.test;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Scanner;

public class Test3 {
    /*
        需求：键盘录入一个日期字符串，程序输出这个日期是一年中的第多少天？
     */
    public static void main(String[] args) throws ParseException {
        // 1. 键盘录入一个日期字符串
        Scanner sc = new Scanner(System.in);
        System.out.println("请输入一个日期(xxxx-xx-xx):");
        String date = sc.next();

        // 2. 创建SimpleDateFormat对象，与对应格式匹配，在调用parse方法，转换为Date类型对象
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");
        Date parse = simpleDateFormat.parse(date);

        // 3. 创建Calendar对象，调用setTime方法，将parse传入，将当前日期修改为键盘录入的日期
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(parse);

        // 4. calendar.get(Calendar.DAY_OF_YEAR) 获取经过的天数
        System.out.println(calendar.get(Calendar.DAY_OF_YEAR));
    }
}
