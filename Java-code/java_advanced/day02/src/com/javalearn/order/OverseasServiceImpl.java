package com.javalearn.order;

public class OverseasServiceImpl implements OrderService{

    public void check() {
        System.out.println("检查IP地址");
    }

    @Override
    public void create() {
        System.out.println("海外业务---创建订单");
    }

    @Override
    public void findOne() {
        System.out.println("海外业务---查询单个订单");
    }

    @Override
    public void findList() {
        System.out.println("海外业务---查询订单列表");
    }

    @Override
    public void cancel() {
        System.out.println("海外业务---取消订单");
    }

    @Override
    public void finish() {
        System.out.println("海外业务---完成订单");
    }

    @Override
    public void paid() {
        System.out.println("海外业务---支付订单");
    }
}
