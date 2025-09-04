package com.javalearn.jdk7.test;

import java.util.Scanner;

public class Test {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        Paid paid = null;

        System.out.println("请选择支付方式: 1. 支付平台支付  2. 银行卡网银支付  3. 信用卡快捷支付");
        System.out.println("请输入您的支付方式:");
        int choice = sc.nextInt();
        System.out.println("请输入您的支付金额:");
        double payMoney = sc.nextDouble();

        switch (choice) {
            case 1:
                paid = new PaymentPlatformsImpl();
                break;
            case 2:
                paid = new BankCardImpl();
                break;
            case 3:
                paid = new CreditCardImpl();
                break;
        }

        paid.paid(payMoney);

    }
}
