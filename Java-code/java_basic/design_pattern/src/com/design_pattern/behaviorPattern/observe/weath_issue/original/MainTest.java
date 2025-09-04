package com.design_pattern.behaviorPattern.observe.weath_issue.original;

public class MainTest {
    public static void main(String[] args) {
        // 创建接入方 currentConditions
        CurrentConditions currentConditions = new CurrentConditions();
        // 创建 WeatherData对象，并将接入方 currentConditions 传递到 WeatherData中
        WeatherData weatherData = new WeatherData(currentConditions);

        // 更新天气情况
        weatherData.setData(30, 150, 40);
    }
}
