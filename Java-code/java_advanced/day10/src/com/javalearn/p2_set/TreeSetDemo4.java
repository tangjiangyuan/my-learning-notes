package com.javalearn.p2_set;

import java.util.Comparator;
import java.util.TreeSet;

public class TreeSetDemo4 {
    public static void main(String[] args) {
        TreeSet<String> ts = new TreeSet<>(new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                return o1.length() - o2.length();
            }
        });
        ts.add("aa");
        ts.add("aaaaa");
        ts.add("a");
        ts.add("aaa");

        System.out.println(ts);
    }
}
