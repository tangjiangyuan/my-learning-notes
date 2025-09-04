package com.design_pattern.behaviorPattern.strategy.duck_issue.improve.imple.fly;

import com.design_pattern.behaviorPattern.strategy.duck_issue.improve.inter.FlyBehavior;

public class NoFlyBehavior implements FlyBehavior {
    @Override
    public void fly() {
        System.out.println("不能飞。。。");
    }
}
