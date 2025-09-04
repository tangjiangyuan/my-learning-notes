package com.javalearn.p1_hashset;

import java.util.HashSet;

public class HashSetDemo3 {
    /*
        桶下标(索引)的计算

        为什么 & 操作运算效率比 % 操作效率高 ?
        --- (n - 1) & hash 是 位运算（按位与），比 hash % n 的 取模运算 更快，
            因为位运算直接由 CPU 支持，而取模运算涉及除法，效率较低。

        如何计算应存入的位置索引？
        答：通过对象的 hashCode()方法得到原始哈希值，再拿着原始哈希值向右移动16位做一次哈希扰动，
            然后再拿着扰动后的哈希值与原始哈希值做一次异或操作，来进行二次哈希操作。(这样做可以减少哈希冲突，得到的链表更散)；
            最后拿着 二次扰动后的哈希值 和 数组长度-1 做与运算

        补充---计算位置索引并不是直接拿着[哈希值 % 数组长度]，而是[(数组长度 - 1) & 哈希值]，因为后者的运算效率更高一些。
        当数组长度是 2^n 时 : (n - 1) & hash 等价于 hash % n（结果范围相同）。
     */
    public static void main(String[] args) {
        int aHash = "a".hashCode() ^ ("a".hashCode() >>> 16); // >>> 右移16位
        System.out.println(aHash % 16);
        System.out.println((16 - 1) & aHash);

        int bHash = "b".hashCode() ^ ("b".hashCode() >>> 16);
        System.out.println(bHash % 16);
        System.out.println((16 - 1) & bHash);

        int cHash = "c".hashCode() ^ ("c".hashCode() >>> 16);
        System.out.println(cHash % 16);
        System.out.println((16 - 1) & cHash);

        int pHash = "p".hashCode() ^ ("p".hashCode() >>> 16);
        System.out.println(pHash % 16);
        System.out.println((16 - 1) & pHash);

        int qHash = "q".hashCode() ^ ("q".hashCode() >>> 16);
        System.out.println(qHash % 16);
        System.out.println((16 - 1) & qHash);

    }
}
