package com.javalearn.regex;

public class RegexDemo {
    /*
        正则表达式 ： 本质来说就是一个字符串，可以指定一些规则，来校验其他字符串。
     */
    /*
        [] : 对单个字符做限制

        1. 字符类
        -------------------------------------------------------------------------
        [abc]           :只能是a, b, c
        [^abc]          :除了a, b, c之外的任何字符
        [a-zA-Z0-9]        :a到z A到Z，包括范围
        [a-d[m-p]]      :a到d，或m通过p:([a-dm-p]联合)
        [a-z&&[def]]    :d, e, 或f(交集)
        [a-z&&[^bc]]    :a到z，除了b和c:([ad-z]减法)
        [a-z&&[^m-p]]   :a到z，除了m到p:([a-lq-z]减法)
        -------------------------------------------------------------------------
     */
    /*
        2. 预定义字符类
        -------------------------------------------------------------------------
        .   : 任何字符
        \d  : 一个数字:[0-9] (常用)
        \D  : 非数字:[^0-9]
        \s  : 一个空白字符:[ \t\n\x0B\f\r]
        \S  : 非空白字符:[^\s]
        \w  : [a-zA-Z_0-9] 英文、数字、下划线 (常用)
        \W  : [^\w] 一个非单词字符

        \   : 转义字符

        System.out.println("\t");       \ ---> t ---> 解密成功 ---> tab键
        -------------------------------------------------------------------------
     */
    /*
        3. 数量:
        -------------------------------------------------------------------------
        X?      : X,0次或一次
        X*      : X,零次或多次(任意次数)
        X+      : X,一次或多次(至少一次)(常用)
        X{n}    : X,正好n次
        X{n, }  : X,至少n次
        X{n, m} : X,至少n但不超过m次
        -------------------------------------------------------------------------
     */
    public static void main(String[] args) {

    }

    private static void regexTest3() {
        String regex1 = "\\d?";
        String regex2 = "\\d*";
        String regex3 = "\\d+";
        String regex4 = "\\d{5}";
        String regex5 = "\\d{5,}";
        String regex6 = "\\d{5,9}";

        System.out.println("1".matches(regex1));
        System.out.println("111123232".matches(regex2));
        System.out.println("111123232".matches(regex3));
        System.out.println("12345".matches(regex4));
        System.out.println("12345678".matches(regex5));
        System.out.println("1234567890".matches(regex6));
    }

    private static void regexTest2() {
        String regex1 = "."; // ".+" : 表示不受数量限制，否则只能对应一个字符
        String regex2 = "\\d";
        String regex3 = "\\D";
        String regex4 = "\\s";
        String regex5 = "\\S";
        String regex6 = "\\w";
        String regex7 = "\\W";


        System.out.println("1".matches(regex1));
        System.out.println("1".matches(regex2));
        System.out.println("a".matches(regex3));
        System.out.println(" ".matches(regex4));
        System.out.println("a".matches(regex5));
        System.out.println("!".matches(regex6));
        System.out.println("!".matches(regex7));

        System.out.println("\"");
        System.out.println('\'');
    }

    private static void regexTest1() {
        String regex1 = "[abc]";
        String regex2 = "[^abc]";
        String regex3 = "[a-zA-Z]";
        String regex4 = "[a-zA-Z0-9]";


        System.out.println("a".matches(regex1));
        System.out.println("x".matches(regex2));
        System.out.println("Y".matches(regex3));
        System.out.println("1".matches(regex4));
    }
}
