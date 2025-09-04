package com.javalearn.jdk7.test;

public class CreditCardImpl implements Paid{

    @Override
    public void paid(double money) {
        System.out.println("通过信用卡快捷支付支付了:" + money + "元！");
    }
}
