package com.javalearn.p4_control;

public class ContinueDemo01 {
    /*
        continue 语句 : 跳过本次循环，进入下一次循环
     */
    public static void main(String[] args) {
        print();
    }

    public static void print() {
        for (int i = 1; i <= 88; i++) {
            if (i == 3 || i == 7 || i == 9) {
                continue;
            }
            System.out.println("第" + i + "名顾客持48小时核算证明进入电影院。。。");
        }
    }
}
