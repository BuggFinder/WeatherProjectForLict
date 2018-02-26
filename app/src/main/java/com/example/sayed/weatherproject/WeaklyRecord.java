package com.example.sayed.weatherproject;

/**
 * Created by nurud on 9/22/2017.
 */

public class WeaklyRecord {
    private int recordNumer;
    private String humidity;
    private String dayName;
    private String temperatureWk;
    private int weatherIcon;

    public WeaklyRecord(String dayName, int weatherIcon, String temperatureWk, String humidity) {
        this.humidity = humidity;
        this.dayName = dayName;
        this.temperatureWk = temperatureWk;
        this.weatherIcon = weatherIcon;
    }


    public WeaklyRecord(int recordNumber) {
        this.recordNumer = recordNumber;
    }

    public void setWindSpeed(String humidity) {
        this.humidity = humidity;
    }

    public void setDayName(String dayName) {
        this.dayName = dayName;
    }

    public void setTemperatureWk(String temperatureWk) {
        this.temperatureWk = temperatureWk;
    }

    public void setWeatherIcon(int weatherIcon) {
        this.weatherIcon = weatherIcon;
    }

    public String getHumidity() {
        return humidity;
    }

    public String getDayName() {
        return dayName;
    }

    public String getTemperatureWk() {
        return temperatureWk;
    }

    public int getWeatherIcon() {
        return weatherIcon;
    }
}
