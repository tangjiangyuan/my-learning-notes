package com.design_pattern.behaviorPattern.observe.weath_issue.improve;

import com.design_pattern.behaviorPattern.observe.weath_issue.original.CurrentConditions;

import java.util.ArrayList;

/**
 * 类是核心
 * 1. 包含最新的天气情况信息
 * 2. 含有 观察者集合，使用 ArrayList管理
 * 3. 当数据有更新时，就主动调用 ArrayList，通知所有的接入方，就可以看到最新信息
 */
public class WeatherData implements Subjective{
    private float temperature;
    private float pressure;
    private float humidity;

    private ArrayList<Observer> observers;

    public float getTemperature() {
        return temperature;
    }

    public float getPressure() {
        return pressure;
    }

    public float getHumidity() {
        return humidity;
    }

    public CurrentConditions getCurrentConditions() {
        return currentConditions;
    }

    public void dataChange() {
        currentConditions.update(getTemperature(), getPressure(), getHumidity());
    }

    // 当有数据更新时，就调用 setData方法
    public void setData(float temperature, float pressure, float humidity) {
        this.temperature = temperature;
        this.pressure = pressure;
        this.humidity = humidity;
        dataChange();
    }

    @Override
    public void registerObserver(Observer observer) {

    }

    @Override
    public void removeObserver(Observer observer) {

    }

    @Override
    public void notifyObservers(Observer observer) {

    }
}
