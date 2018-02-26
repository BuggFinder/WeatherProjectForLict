package com.example.sayed.weatherproject;

/**
 * Created by nurud on 9/22/2017.
 */

public class HourlyRecord {
    private int weatherImgIcon;
    private  String time;
    private String temperature;

    public HourlyRecord(int weatherImgIcon, String time, String temperature) {
        this.weatherImgIcon = weatherImgIcon;
        this.time = time;
        this.temperature = temperature;
    }

    public HourlyRecord() {
    }

    public int getWeatherImgIcon() {
        return weatherImgIcon;
    }

    public String getTime() {
        return time;
    }

    public String getTemperature() {
        return temperature;
    }
}
