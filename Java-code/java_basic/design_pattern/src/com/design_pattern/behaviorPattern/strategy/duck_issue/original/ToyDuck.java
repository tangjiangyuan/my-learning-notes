package com.design_pattern.behaviorPattern.strategy.duck_issue.original;

public class ToyDuck extends Duck{
    @Override
    public void display() {
        System.out.println("这是玩具鸭~");
    }

    // 需要重写父类中所有方法
    @Override
    public void quack() {
        System.out.println("玩具鸭不能叫~");
    }

    @Override
    public void fly() {
        System.out.println("玩具鸭不能飞~");
    }

    @Override
    public void swim() {
        System.out.println("玩具鸭不能游泳~");
    }
}
