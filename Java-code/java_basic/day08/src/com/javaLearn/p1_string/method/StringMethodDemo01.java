package com.javaLearn.p1_string.method;

public class StringMethodDemo01 {
    /*
        String 类中用于比较的方法 :
            public equals(Object anObject)。将此字符串与指定对象进行比较。
            public equalsIgnoreCase(String anotherString) 。将此 String与其他 String比较，忽略案例注意事项，不考录大小写。
     */
    public static void main(String[] args) {

        String s1 = "abc";
        String s2 = new String("abc");

        System.out.println(s1 == s2); // 比较的是地址值
        System.out.println(s1.equals(s2)); // 比较的是内容

        System.out.println("------------------------------");

        String ss1 = "abc";
        String ss2 = "ABC";
        System.out.println(ss1.equals(ss2));// false
        System.out.println(ss1.equalsIgnoreCase(ss2));// true
    }
}
