package com.javaLearn.p2_stringbuilder;

public class StringBuilderDemo02 {
    /*
        StringBuilder 的介绍:

            1. 一个可变的字符序列
            2. StringBuilder 是字符串缓冲区，将其理解是容器，这个容器可以存储任意数据类型，但是只要进入到这个容器，全部编程字符串。

        StringBuilder 的构造方法 :

            1. public StringBuilder() 创建一个空白的字符串缓冲区（容量），初始容量为16个字符。(如果不够，会自动扩容)

            2. public StringBuilder(String str) 创建一个空白的字符串缓冲区（容量），容器创建好之后，就会带有参数的内容。
     */
    public static void main(String[] args) {

        StringBuilder sb = new StringBuilder();

        sb.append("12346789123456789");
        System.out.println(sb);

        StringBuilder sb1 = new StringBuilder("123456");
        System.out.println(sb1);

    }

    private static void print1() {
        StringBuilder sb = new StringBuilder();
        System.out.println(sb);

        sb.append("红色");
        System.out.println(sb);

        sb.append("蓝色");
        System.out.println(sb);

        sb.append("绿色");
        System.out.println(sb);
    }

    private static void print2() {
        StringBuilder sb = new StringBuilder();

        sb.append(100);
        sb.append(12.3);
        sb.append(false);
        sb.append('a');
        sb.append("哇");

        System.out.println(sb);
    }
}
