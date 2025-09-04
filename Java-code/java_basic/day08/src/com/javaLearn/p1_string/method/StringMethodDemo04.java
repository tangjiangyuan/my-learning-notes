package com.javaLearn.p1_string.method;

public class StringMethodDemo04 {
    /*
        String 类的替换:

            public String replace(CharSequence target, CharSequence replacement)
                target : 旧值
                replace : 新值

     */
    public static void main(String[] args) {
        String s = "i love you";
        String re = s.replace("love", "hate");
        System.out.println(re);
    }
}
