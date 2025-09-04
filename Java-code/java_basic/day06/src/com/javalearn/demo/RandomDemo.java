package com.javalearn.demo;

import java.util.Random;

public class RandomDemo {
    /*
        从数组中产生取出一个数据值

        根据数组的长度，产生一个随机数，拿着这个随机数，当作索引去数组中获取元素。
     */
    public static void main(String[] args) {
                        // 0     1      2       3      4      5
        String[] sArr = {"米饭", "馒头", "包子", "麻花", "面条", "汉堡"};

        Random r = new Random();

        int i = r.nextInt(sArr.length);  // 将产生的随机数和数组的索引建立联系，通过索引再获取数组的元素

        System.out.println(i);
        System.out.println(sArr[i]);
    }
}
