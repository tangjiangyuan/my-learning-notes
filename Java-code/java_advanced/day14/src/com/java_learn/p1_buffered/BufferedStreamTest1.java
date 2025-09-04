package com.java_learn.p1_buffered;

import java.io.*;
import java.util.TreeSet;

public class BufferedStreamTest1 {
    /*
        案例 --- 请对D:\Dev-work\java_advanced\day14\出师表.txt 文件做排序操作
     */
    static TreeSet<String>  ts = new TreeSet<>();
    public static void main(String[] args) throws IOException {
        exercise1();
    }

    private static void exercise1() throws IOException {
        // 创建 TreeSet集合 存放每一行(备份)
        TreeSet<String> ts = new TreeSet<>();
        BufferedReader br = new BufferedReader(new FileReader("D:\\Dev-work\\java_advanced\\day14\\出师表.txt"));
        String line;
        while ((line = br.readLine()) != null) {
            ts.add(line);
        }
        br.close();

        // ts.forEach(s -> System.out.println(s));
        // 创建字符输出流接收排好序的数据
        BufferedWriter bw = new BufferedWriter(new FileWriter("D:\\出师表.txt"));
        for (String content : ts) {
            // 写出数据
            bw.write(content);
            bw.newLine();
        }
        bw.close();
    }

    private static void exercise2() throws IOException {
        BufferedReader br = new BufferedReader(new FileReader("D:\\Dev-work\\java_advanced\\day14\\出师表.txt"));
        String line;
        while ((line = br.readLine()) != null) {
            ts.add(line);
        }
        br.close();

        BufferedWriter bw = new BufferedWriter(new FileWriter("D:\\出师表.txt"));
        for (String context : ts) {
            bw.write(context);
            bw.newLine();
        }
        bw.close();
    }

    public static void exercise3() throws Exception {
        TreeSet<String> ts = new TreeSet<>();
        BufferedReader br = new BufferedReader(new FileReader("D:\\Dev-work\\java_advanced\\day14\\出师表.txt"));

        String line;
        while ((line = br.readLine()) != null) {
            ts.add(line);
        }
        br.close();

        BufferedWriter bw = new BufferedWriter(new FileWriter("D:\\出师表.txt"));
        for (String content : ts) {
            bw.write(content);
            bw.newLine();
        }
        bw.close();
    }
}
