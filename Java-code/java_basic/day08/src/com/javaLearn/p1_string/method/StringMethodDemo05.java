package com.javaLearn.p1_string.method;

public class StringMethodDemo05 {
    /*
        String 字符串的切割方法 :

            public String[] split(String regex) : 根据传入的字符串作为规则，切割当前字符串

        建议 : 先正常指定切割规则，后来发现没有得到自己要的效果，就可以尝试在规则前面，加入 \\
     */
    public static void main(String[] args) {

        String s = "192-168-1-1";

        String[] sArr = s.split("-"); // "." 表示正通规则，可代表任意字符；通过"\\."来切割
        // String[] sArr = s.split(".");

        for (int i = 0; i < sArr.length; i++) {
            System.out.println(sArr[i]);
        }
    }
}
