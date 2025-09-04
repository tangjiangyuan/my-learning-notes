package com.design_pattern.behaviorPattern.strategy.duck_issue.improve.entity;

import com.design_pattern.behaviorPattern.strategy.duck_issue.improve.inter.FlyBehavior;
import com.design_pattern.behaviorPattern.strategy.duck_issue.improve.inter.QuackBehavior;

public abstract class Duck {
    // 属性，策略接口
    FlyBehavior flyBehavior;
    QuackBehavior quackBehavior;

    public Duck() {}

    public abstract void display();

    public void fly() {
        if (flyBehavior != null) {
            flyBehavior.fly();
        }
    }

    public void quack() {
        if (quackBehavior != null) {
            quackBehavior.quack();
        }
    }

    public void setFlyBehavior(FlyBehavior flyBehavior) {
        this.flyBehavior = flyBehavior;
    }

    public void setQuackBehavior(QuackBehavior quackBehavior) {
        this.quackBehavior = quackBehavior;
    }
}
