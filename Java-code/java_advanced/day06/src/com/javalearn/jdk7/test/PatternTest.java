package com.javalearn.jdk7.test;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class PatternTest {
    /*
        需求 : 请把下面文本中的电话，邮箱，座机号码，热线都爬取出来
     */
    public static void main(String[] args) {
        String data = "来黑马程序员学习Java，" +
                "电话：18139553548，19119390827或者联系" +
                "邮箱：boniu@itcast.cn 邮箱：bozai@itcast.cn 邮箱2：dlei0009@163.com" +
                "座机电话：01036517895，010-98951256" +
                "热线电话：400-618-9090，400-618-4000，4006184000，4006189090";

        String regex = "[1][3-9]\\d{9}|" +
                "\\w+[@][\\w&&[^_]]+(\\.[a-z]{2,3})+|" +
                "[0]\\d{2,3}-?\\d{7,8}|" +
                "\\d{3}-?\\d{3}-?\\d{4}";

        // 1. 将正则表达式封装为 Pattern 对象
        Pattern pattern = Pattern.compile(regex);

        // 2. 获取匹配器对象
        Matcher matcher = pattern.matcher(data);

        // System.out.println(matcher.find()); // 调用一次，爬取一次
        // System.out.println(matcher.group());

        while (matcher.find()) {
            System.out.println(matcher.group());
        }
    }
}
