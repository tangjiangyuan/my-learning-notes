package com.design_pattern.behaviorPattern.strategy.duck_issue.original;

public class MainTest {
    public static void main(String[] args) {
        WildDuck wildDuck = new WildDuck();

        wildDuck.display();
        wildDuck.quack();
        wildDuck.swim();
        wildDuck.fly();
    }
}
