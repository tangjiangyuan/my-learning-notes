package com.javaLearn.p1_string.method;

public class StringMethodDemo02 {
    /*
        String 类中用于遍历的方法

            1. public char[] toCharArray() : 将此字符串转换为新的字符数组。

            2. public char charAt(int index) : 返回 char指定索引处的值。

            3. public int length() 返回此字符串的长度。

            -----------------------------------------------------------

            比较而言，第一种遍历方式效率更高
     */
    public static void main(String[] args) {
        print1();
        System.out.println("----");
        print2();
    }

    /**
     * 字符串遍历的第二种遍历方式
     */
    private static void print2() {
        String s = "ayaka";
        for (int i = 0; i < s.length(); i++) { // 循环中重复调用length()方法，一直进栈弹栈，影响代码运行效率
            char c = s.charAt(i);
            System.out.println(c);
        }
    }

    /**
     * 字符串遍历的第一种方式
     */
    private static void print1() {
        String s = "violet";
        char[] chars = s.toCharArray(); // 只调用了一次方法
        for (int i = 0; i < chars.length; i++) {
            System.out.println(chars[i]);
        }
    }
}
