package com.design_pattern.behaviorPattern.observe.weath_issue.improve;

public class CurrentConditions implements Observer {
    private float temperature; // 气温
    private float pressure; // 压力
    private float humidity; // 湿度

    public void display() {
        System.out.println("Today mTemperature:" + temperature + "***");
        System.out.println("Today mPressure:" + pressure + "***");
        System.out.println("Today mHumidity:" + humidity + "***");
    }

    @Override
    public void update(float temperature, float pressure, float humidity) {
        this.temperature = temperature;
        this.pressure = pressure;
        this.humidity = humidity;
        display();
    }
}
