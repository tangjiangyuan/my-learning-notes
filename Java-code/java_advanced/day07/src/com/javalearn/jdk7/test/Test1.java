package com.javalearn.jdk7.test;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

public class Test1 {
    /*
        需求：计算你来到这个世界多少天了

        分析：
            1. 键盘录入用户生日 (日期字符串)
            2. 创建SimpleDateFormat对象，指定模式，用于将日期字符串解析为Date日期对象 (birthdayDate)
            3. 创建Date日期对象，封装此刻的时间 (todayDate)
            4. long time = todayDate.getTime() - birthdayDate.getTime();
            5. 将毫秒值，转换为天的单位
                    time / 1000 / 60 / 60 / 24
     */
    public static void main(String[] args) throws ParseException {
        // 1. 键盘录入用户生日 (日期字符串)
        Scanner sc = new Scanner(System.in);
        System.out.println("请输入您的生日(xxxx-xx-xx):");
        String birthday = sc.next();

        // 2. 创建SimpleDateFormat对象，指定模式，用于将日期字符串解析为Date日期对象 (birthdayDate)
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");
        Date birthdayDate = simpleDateFormat.parse(birthday);
        // System.out.println(birthdayDate.getTime());

        // 3. 创建Date日期对象，封装此刻的时间 (todayDate)
        Date todayDate = new Date();
        // System.out.println(todayDate.getTime());

        // 4. long time = todayDate.getTime() - birthdayDate.getTime();
        long time = todayDate.getTime() - birthdayDate.getTime();
        // System.out.println(time);

        // 5. 将毫秒值，转换为天的单位
        //                  秒    分   时   天
        long day = time / 1000 / 60 / 60 / 24;
        System.out.println("您来到这个世界" + day + "天了。");
    }
}
