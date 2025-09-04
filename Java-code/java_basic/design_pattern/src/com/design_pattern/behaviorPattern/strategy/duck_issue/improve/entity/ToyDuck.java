package com.design_pattern.behaviorPattern.strategy.duck_issue.improve.entity;

import com.design_pattern.behaviorPattern.strategy.duck_issue.improve.imple.fly.NoFlyBehavior;
import com.design_pattern.behaviorPattern.strategy.duck_issue.improve.imple.quack.NoQuackBehavior;

public class ToyDuck extends Duck{

    public ToyDuck() {
        flyBehavior = new NoFlyBehavior();
        quackBehavior = new NoQuackBehavior();
    }

    @Override
    public void display() {
        System.out.println("玩具鸭~");
    }
}
