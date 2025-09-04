package com.javalearn.test;

import java.util.Random;
import java.util.Scanner;

public class Test7_1 {
    public static void main(String[] args) {
        // 获取提供验证码的数组
        char[] randomCaptcha = provideCaptcha();
        // 获取生成的验证码
        String captcha = generateCaptcha(randomCaptcha);
        System.out.print("产生的验证码是 : " + captcha);
        // 验证输入的数据与验证码是否相等
        checkCaptcha(captcha);
    }

    /**
     * 此方法是用来提供验证码的数组
     *
     * @return
     */
    public static char[] provideCaptcha() {

        char[] randomCaptcha = new char[26 + 26 + 10];
        int index = 0;
        // 存入小写字母
        for (char i = 'a'; i <= 'z'; i++) {
            randomCaptcha[index] = i;
            index++;
        }
        // 存入大写字母
        for (char i = 'A'; i <= 'Z'; i++) {
            randomCaptcha[index] = i;
            index++;
        }
        // 存入0-9数字
        for (char i = '0'; i <= '9'; i++) {
            randomCaptcha[index] = i;
            index++;
        }
        // 打印字符类型的数组名时，不会产生地址值，而是直接打印元素
        // System.out.println(randomCaptcha);

        return randomCaptcha;
    }

    /**
     * 此方法用来生成验证码
     * @param randomCaptcha
     * @return
     */
    public static String generateCaptcha(char[] randomCaptcha) {

        Random r = new Random();
        String s = "";
        for (int i = 0; i < 5; i++) {
            int index = r.nextInt(randomCaptcha.length);
            s += randomCaptcha[index];
        }
        return s;
    }

    /**
     * 此方法从键盘输入验证码与生成的验证码做对比
     * @param captcha
     */
    public static void checkCaptcha(String captcha) {
        Scanner sc = new Scanner(System.in);
        while (true) {
            System.out.println();
            System.out.println("请输入 :");
            String inputCaptcha = sc.next();

            if (inputCaptcha.equalsIgnoreCase(captcha)){
                System.out.println("验证成功");
                break;
            } else {
                System.out.println("抱歉，输入错误！");
            }
        }

    }
}
