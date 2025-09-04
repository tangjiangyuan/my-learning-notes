package com.design_pattern.behaviorPattern.strategy.duck_issue.improve.entity;

import com.design_pattern.behaviorPattern.strategy.duck_issue.improve.imple.fly.GoodFlyBehavior;
import com.design_pattern.behaviorPattern.strategy.duck_issue.improve.imple.quack.GaGaQuackBehavior;

public class WildDuck extends Duck{

    public WildDuck() {
        flyBehavior = new GoodFlyBehavior();
        quackBehavior = new GaGaQuackBehavior();
    }

    @Override
    public void display() {
        System.out.println("野生鸭~");
    }

}
