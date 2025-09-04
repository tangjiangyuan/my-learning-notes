package com.java_learn.stream.p4_character.reader;

import java.io.FileReader;

public class FileReaderDemo2 {
    /*
        FileReader 读取数据，其实也是内部内置了一个字节数组，读取8192个元素。
            如果是正数，表示英文；如果是负数，表示中文。
     */
    public static void main(String[] args) throws Exception {
        FileReader fr = new FileReader("D:\\a.txt"); // a你好b

        int i = fr.read();
        System.out.println(i);
    }
}
