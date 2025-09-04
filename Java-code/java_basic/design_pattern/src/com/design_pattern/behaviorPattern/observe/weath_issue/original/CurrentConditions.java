package com.design_pattern.behaviorPattern.observe.weath_issue.original;

/**
 * 显示当前天气情况(可以理解是气象站自己的网站)
 */
public class CurrentConditions {
    private float temperature; // 气温
    private float pressure; // 压力
    private float humidity; // 湿度

    public void update(float temperature, float pressure, float humidity) {
        this.temperature = temperature;
        this.pressure = pressure;
        this.humidity = humidity;
        display();
    }

    public void display() {
        System.out.println("Today mTemperature:" + temperature + "***");
        System.out.println("Today mPressure:" + pressure + "***");
        System.out.println("Today mHumidity:" + humidity + "***");
    }
}
