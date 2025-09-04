package com.javalearn.p2_file.test;

import java.io.File;
import java.util.HashMap;
import java.util.function.BiConsumer;

public class FileTest5 {
    /*
        案例 --- 需求 : 键盘录入一个文件夹路径，统计文件夹中每种文件的个数并打印(考虑子文件)
        打印格式如下 :
            txt : 3个
            doc : 4个
            jpg : 6个
     */

    static HashMap<String, Integer> hm = new HashMap<>();
    static int count = 0;

    public static void main(String[] args) {
        getNumbersOfDiverseFiles(FileTest1.getDirPath());
        hm.forEach(new BiConsumer<String, Integer>() {
            @Override
            public void accept(String key, Integer value) {
                System.out.println(key + ":" + value + "个");
            }
        });
        System.out.println("没有后缀名的文件个数:" + count);
    }

    public static void getNumbersOfDiverseFiles(File dir) {
        File[] files = dir.listFiles();
        for (File file : files) {
            if (file.isFile()) { // 是文件，统计个数
                // 1. 获取文件名
                String fileName = file.getName();
                if (fileName.contains(".")) { // 有后缀的文件(字符串中的contains()方法不适用正则表达式)
                    // 2. 获取后缀名
                    String[] sArr = fileName.split("\\."); // 此处用到了正则表达式，需要\\进行转译
                    String type = sArr[sArr.length - 1];
                    // 3. 统计不同文件的个数
                    if (!hm.containsKey(type)) { // 如果不存在该类型文件，则个数为1
                        hm.put(type, 1);
                    } else { // 如果存在该类型文件，则获取旧值，并再次基础上+1
                        hm.put(type, hm.get(type) + 1);
                    }
                } else { // 没有后缀的文件，单独统计
                    count++;
                }
            } else { // 是文件夹，进行递归调用
                if (file.listFiles() != null) {
                    getNumbersOfDiverseFiles(file);
                }
            }
        }
    }
}
