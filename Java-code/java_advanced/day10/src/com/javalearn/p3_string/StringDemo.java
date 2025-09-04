package com.javalearn.p3_string;

import java.util.TreeSet;

public class StringDemo {
    public static void main(String[] args) {

        String s1 = "a";
        String s2 = "b";
        System.out.println(s1.compareTo(s2));

        String s3 = "张";
        String s4 = "李";
        System.out.println(s3.compareTo(s4));

        TreeSet<String> ts = new TreeSet<>();

        ts.add("a");
        ts.add("b");
        ts.add("c");
        ts.add("baa");
        ts.add("az");

        System.out.println(ts);
    }
}
