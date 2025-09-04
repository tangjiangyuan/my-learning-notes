package com.design_pattern.behaviorPattern.observe.weath_issue.improve;

// 观察者接口，由观察者来实现
public interface Observer {
    void update(float temperature, float pressure, float humidity);
}
