package com.example.sayed.weatherproject;

/**
 * Created by nurud on 9/22/2017.
 */

public class HourlyRecord {
    private int recodNumber;
    private int weatherImgIcon;
    private  String time;
    private String temperature;

    public HourlyRecord(int weatherImgIcon, String time, String temperature) {
        this.weatherImgIcon = weatherImgIcon;
        this.time = time;
        this.temperature = temperature;
    }

    public HourlyRecord(int recodNumber) {
        this.recodNumber = recodNumber;
    }

    public void setWeatherImgIcon(int weatherImgIcon) {
        this.weatherImgIcon = weatherImgIcon;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public void setTemperature(String temperature) {
        this.temperature = temperature;
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
