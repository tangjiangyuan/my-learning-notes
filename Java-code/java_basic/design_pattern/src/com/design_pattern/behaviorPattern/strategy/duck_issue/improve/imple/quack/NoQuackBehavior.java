package com.design_pattern.behaviorPattern.strategy.duck_issue.improve.imple.quack;

import com.design_pattern.behaviorPattern.strategy.duck_issue.improve.inter.QuackBehavior;

public class NoQuackBehavior implements QuackBehavior {
    @Override
    public void quack() {
        System.out.println("不能叫。。。");
    }
}
