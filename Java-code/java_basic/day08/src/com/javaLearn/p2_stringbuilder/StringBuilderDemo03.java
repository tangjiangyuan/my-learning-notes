package com.javaLearn.p2_stringbuilder;

public class StringBuilderDemo03 {
    /*
        StringBuilder 的常见成员方法 :

            1. public StringBuilder append(任意类型) : 添加数据，并返回自己

            2. public StringBuilder reverse() : 将缓冲区中的内容，进行反转

            3. public int length() : 返回长度

            4. public String toString() : 将缓冲区中的数据，以String字符串类型返回
     */
    public static void main(String[] args) {

        StringBuilder sb = new StringBuilder();

        // 链式编程: 调用的方法，返回的结果是对象，就可以继续向下调用方法。
        sb.append("红色").append("蓝色").append("绿色");
        System.out.println(sb);

        // public StringBuilder reverse() : 将缓冲区中的内容，进行反转
        sb.reverse();
        System.out.println(sb);

        // public int length() : 返回长度
        System.out.println(sb.length());

        // public String toString() : 将缓冲区中的数据，以String字符串类型返回
        // 情况 : 数据在 StringBuilder当中，想要调用的方法，StringBuilder中没有，但是String有
        // 解决 : 转换为 String，再调用
        String result = sb.toString();

        String[] sArr = result.split("色");

        for (int i = 0; i < sArr.length; i++) {
            System.out.println(sArr[i]);
        }
    }
}
