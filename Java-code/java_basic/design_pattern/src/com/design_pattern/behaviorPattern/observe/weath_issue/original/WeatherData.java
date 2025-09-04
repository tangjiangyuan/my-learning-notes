package com.design_pattern.behaviorPattern.observe.weath_issue.original;

/**
 * 类是核心
 * 1. 包含最新的天气情况信息
 * 2. 含有 CurrentConditions 对象
 * 3. 当数据有更新时，就主动调用 CurrentConditions对象中的 update方法(含有 display方法) - 这样接入方就可以看到信息
 */
public class WeatherData {
    private float temperature;
    private float pressure;
    private float humidity;
    private CurrentConditions currentConditions;

    public WeatherData(CurrentConditions currentConditions) {
        this.currentConditions = currentConditions;
    }

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
}
