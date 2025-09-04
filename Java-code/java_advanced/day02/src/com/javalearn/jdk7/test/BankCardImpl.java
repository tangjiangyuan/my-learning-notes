package com.javalearn.jdk7.test;

public class BankCardImpl implements Paid{

    @Override
    public void paid(double money) {
        System.out.println("通过银行卡网银支付了:" + money + "元！");
    }
}
