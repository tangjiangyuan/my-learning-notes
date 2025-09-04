package com.design_pattern.behaviorPattern.strategy.duck_issue.original;

public class PekingDuck extends Duck{  // 北京鸭
    @Override
    public void display() {
        System.out.println("这时北京鸭");
    }

    // 因为北京鸭不能飞，所以需要重写 fly()方法
    @Override
    public void fly() {
        System.out.println("北京鸭不能飞~");
    }
}
