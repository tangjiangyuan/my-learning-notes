package com.design_pattern.behaviorPattern.strategy.duck_issue.original;

public class WildDuck extends Duck{ // 野鸭
    @Override
    public void display() {
        System.out.println("这是野鸭。");
    }
}
