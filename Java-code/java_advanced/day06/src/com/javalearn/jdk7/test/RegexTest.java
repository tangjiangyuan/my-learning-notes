package com.javalearn.jdk7.test;

public class RegexTest {
    /*
        1. QQ号正则
                不能以0开头
                全部是数字
                5~12位
        2. 手机号正则
                必须是1开头
                第二位: 3 4 5 6 7 8 9
                全部是数字，必须是11位
        3. 邮箱正则
                zhangSan@itcast.cn
                zhangsan@163.com
                123456@qq.com
                zhangsan@sina.com
                zhangsan@itcast.qq.com
                zhangsan@xxx.edu
                zhangsan@xxx.org
     */
    public static void main(String[] args) {
        regexQQ();
    }

    /**
     * QQ号正则
     */
    public static void regexQQ() {
        String regex1 = "[^0]\\d{4,11}";
        String regex2 = "[1-9]\\d{4,11}";

        System.out.println("1908286988".matches(regex1));
        System.out.println("3390857400".matches(regex2));
    }

    /**
     * 手机号正则
     */
    public static void regexPhoneNumber() {
        String regex1 = "[1][^012]\\d{9}";
        String regex2 = "[1][3-9]\\d{9}";

        System.out.println("19119390827".matches(regex1));
        System.out.println("18139553548".matches(regex2));
    }

    /**
     * 邮箱正则
     */
    public static void regexEmail() {
        String regex1 = "\\w{6,}[@][\\w&&[^_]]+\\.\\w{2,3}\\S?[c]?[o]?[m]?";
        String regex2 = "\\w+[@][\\w&&[^_]]+(\\.[a-z]{2,3})+";

        System.out.println("zhangSan@itcast.cn".matches(regex1));
        System.out.println("zhangsan@163.com".matches(regex1));
        System.out.println("123456@qq.com".matches(regex1));
        System.out.println("zhangsan@sina.com".matches(regex1));
        System.out.println("zhangsan@itcast.qq.com".matches(regex2));
        System.out.println("zhangsan@xxx.edu".matches(regex1));
    }
}
