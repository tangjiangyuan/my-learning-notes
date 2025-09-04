package com.javaLearn.p1_string.method;

public class StringMethodDemo03 {
    /*
        String 类的截取方式 :

            public String substring(int beginIndex) : 返回一个(从开始索引到字符串末尾的)字符串。

            public String substring(int beginIndex, int endIndex) 返回一个(在起始索引到结束索引之间的所包含的)字符串.
                    但是不包括结束索引的字符。左闭右开。

            注意 : 截取出来的内容，是作为新的字符串返回，需要找变量接收。
     */
    public static void main(String[] args) {

        String s = "HelloWorld";

        String result = s.substring(5);
        System.out.println(result);

        System.out.println("------------");

        String result2 = s.substring(4, 7);
        System.out.println(result2);

    }
}
