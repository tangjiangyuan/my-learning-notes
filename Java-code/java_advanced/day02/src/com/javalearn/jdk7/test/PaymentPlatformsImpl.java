package com.javalearn.jdk7.test;

public class PaymentPlatformsImpl implements Paid{

    @Override
    public void paid(double money) {
        System.out.println("通过支付平台支付了:" + money + "元！");
    }
}
