package com.javaLearn.p2_stringbuilder;

public class StringBuilderDemo01 {
    /*
        StringBuilder 的作用 : 提高字符串操作的效率

            1. StringBuilder 的特点
            2. StringBuilder 的构造方法
            3. StringBuilder 的常见成员方法
            4. 练习
            5. StringBuilder 提高效率
     */
    public static void main(String[] args) {

        long start = System.currentTimeMillis();

        StringBuilder sb = new StringBuilder();
        for (int i = 1; i <= 10000; i ++) {
            sb.append(i);
        }
        System.out.println(sb);

        long end = System.currentTimeMillis();
        System.out.println(end - start); // 12 ms

    }

    private static void method() {
        // 获取 1970年1月1日0时0分0秒到现在所经历的毫秒值 （1秒 = 1000毫秒）
        // 想要获取一段代码执行多长时间，可通该方法来确定
        long start = System.currentTimeMillis();

        String s = "";
        for (int i = 1; i <= 10000; i++) {
            s += i;
        }
        System.out.println(s);

        long end = System.currentTimeMillis();
        System.out.println(end - start); // 687 ms
    }
}
