package com.javaLearn.p1_string;

public class StringDemo02 {
    /*
        String 类常见构造方法 :

            public String() : 创建一个空白字符，里面不包含任何内容
            public String(char[] chs) : 根据传入的字符数组，创建字符串对象
            public String(String original) : 根据传入的字符串，来创建字符串对象

            ------------------------------------------------------------------

            1. 打印对象名，会看到对象的内存地址，这里打印字符串对象，为什么没有看到地址值
                    回答 : 暂不解释
                    TODO : 面向对象（继承），方法重写，Object类，toString方法

            2. 这三个构造方法，创建字符串对象，都没有双引号直接创建来的方便

            ------------------------------------------------------------------

            字符串对象，两种创建方式的区别


                    1. 双引号直接创建
                    2. 通过构造方法创建
     */
    public static void main(String[] args) {

        // public String() : 创建一个空白字符，里面不包含任何内容
        String s1 = new String();
        System.out.println(s1);

        // public String(char[] chs) : 根据传入的字符数组，创建字符串对象
        char[] chs = {'a','b','c'};
        String s2 = new String(chs);// 将一个一个的字符拼接为字符串
        System.out.println(s2);

        // public String(String original) : 根据传入的字符串，来创建字符串对象
        String s3 = new String("abc");
        System.out.println(s3);
    }
}
