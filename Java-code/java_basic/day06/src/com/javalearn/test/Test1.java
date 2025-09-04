package com.javalearn.test;

public class Test1 {
    /*
        案例 ： 逢7跳过
        规则 ： 从任意一个数字开始报数，当你要报的数字包含 7或者 是 7的倍数时都要说：过。
        在控制台打印出1~100之间的满足逢7比过规则的数据
     */
    public static void main(String[] args) {
        printNum();
    }

    public static void printNum() {
        // 1. 循环遍历 1~100
        for (int i = 1; i <= 100; i++) {
            // 2. 判断当前数字 是否是 7的倍数或者包含 7，如果是则打印该数字
            int ge = i % 10;
            int shi = i / 10 % 10;
            if (i % 7 == 0 || ge == 7 || shi == 7){
                System.out.println(i);
            }
        }
    }

}
