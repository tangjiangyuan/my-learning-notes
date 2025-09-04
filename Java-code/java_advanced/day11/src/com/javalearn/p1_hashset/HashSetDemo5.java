package com.javalearn.p1_hashset;

import java.util.HashSet;

public class HashSetDemo5 {
    public static void main(String[] args) {

        // findHashIsOne();

        HashSet<String> hs = new HashSet<>();

        hs.add("a");
        hs.add("q");
        hs.add("Ñ");
        hs.add("á");
        hs.add("ñ");
        hs.add("ā");
        hs.add("A");
        hs.add("Ǒ");

        System.out.println("8个元素的时候:" + hs);

        hs.add("Ł");

        System.out.println("9个元素的时候:" + hs);

        hs.add("ǡ");
        hs.add("Ǳ");
        hs.add("ȁ");

        System.out.println("12个元素的时候:" + hs);
    }

    /**
     * 该方法是用来查看哪些元素在数组中的索引位置是 1
     */
    private static void findHashIsOne() {
        for (int i = 97; i <= 1000; i++) {
            char c = (char) i;
            String s = String.valueOf(c);
            int hash = s.hashCode();
            hash = (hash ^ (hash >>> 16)) % 16;
            if (hash == 1) {
                System.out.println(s);
            }
        }
    }
}
