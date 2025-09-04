package com.javalearn.test;

import java.util.Random;
import java.util.Scanner;

public class Test7 {
    /*
        案例 : 随机产生验证码(captcha)
        需求 : 请从26个英文字母（大小写都包含），以及数字0-9中，随机产生一个5位的字符串验证码
        并打印在控制台
        效果 : uYq8I, 3r4Zj
     */
    public static void main(String[] args) {
        randomCaptcha();
    }

    public static void randomCaptcha() {
        // 1. 定义一个数组提供验证码
        char[] captArr = {
                'a', 'b', 'c', 'd', 'e', 'f', 'g', 'h', 'i', 'j', 'k', 'l', 'm', 'n', 'o', 'p', 'q', 'r',
                's', 't', 'u', 'v', 'w', 'x', 'y', 'z', '0', '1', '2', '3', '4', '5', '6', '7', '8', '9',
                'A', 'B', 'C', 'D', 'E', 'F', 'G', 'H', 'I', 'J', 'K', 'L', 'M', 'N', 'O', 'P', 'Q', 'R',
                'S', 'T', 'U', 'V', 'W', 'X', 'Y', 'Z'
        };
        Random r = new Random();
        String checkCode = ""; // 拼接每一个字符
        for (int i = 0; i < 5; i++) {
            int index = r.nextInt(captArr.length);// 通过产生的随机数跟验证码数组的索引建立联系
            checkCode += captArr[index];
        }
        System.out.println(checkCode);
        // 3. 键盘输入的和验证码一致，则提示成功
        while (true) {
            // 2. 生成验证码后，键盘录入验证码
            Scanner sc = new Scanner(System.in);
            String inputCheckCode = sc.next();
            if (inputCheckCode.equalsIgnoreCase(checkCode)){ // 字符串的比较需要用到 equals方法，暂时这么写
                System.out.println("验证成功！");
                break;
            }else {
                // 4. 否则，提示失败，并重新生成验证码，再次验证
                System.out.println("输入错误，验证失败！！！");
            }
        }
    }
}
