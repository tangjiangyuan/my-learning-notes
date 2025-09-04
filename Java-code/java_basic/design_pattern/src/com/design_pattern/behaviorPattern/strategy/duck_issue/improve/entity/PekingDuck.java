package com.design_pattern.behaviorPattern.strategy.duck_issue.improve.entity;

import com.design_pattern.behaviorPattern.strategy.duck_issue.improve.imple.fly.BadFlyBehavior;
import com.design_pattern.behaviorPattern.strategy.duck_issue.improve.imple.quack.GaGaQuackBehavior;

public class PekingDuck extends Duck{

    public PekingDuck() {
        flyBehavior = new BadFlyBehavior();
        quackBehavior = new GaGaQuackBehavior();
    }

    @Override
    public void display() {
        System.out.println("北京鸭~");
    }
}
