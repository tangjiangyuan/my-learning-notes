package com.design_pattern.behaviorPattern.strategy.duck_issue.improve;

import com.design_pattern.behaviorPattern.strategy.duck_issue.improve.entity.PekingDuck;
import com.design_pattern.behaviorPattern.strategy.duck_issue.improve.entity.ToyDuck;
import com.design_pattern.behaviorPattern.strategy.duck_issue.improve.entity.WildDuck;
import com.design_pattern.behaviorPattern.strategy.duck_issue.improve.imple.fly.NoFlyBehavior;
import com.design_pattern.behaviorPattern.strategy.duck_issue.improve.imple.quack.NoQuackBehavior;

public class MainTest {
    public static void main(String[] args) {
        WildDuck wildDuck = new WildDuck();
        wildDuck.display();
        wildDuck.fly();

        ToyDuck toyDuck = new ToyDuck();
        toyDuck.display();
        toyDuck.fly();

        PekingDuck pekingDuck = new PekingDuck();
        pekingDuck.display();
        pekingDuck.fly();

        System.out.println("------------");

        // 动态改变某个鸭子得飞行能力
        pekingDuck.setFlyBehavior(new NoFlyBehavior());
        System.out.print("北京鸭的实际飞行能力是:");
        pekingDuck.fly();

        pekingDuck.setQuackBehavior(new NoQuackBehavior());
        System.out.print("北京鸭修改后的叫声是:");
        pekingDuck.quack();
    }
}
