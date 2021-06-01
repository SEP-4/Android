package com.example.sep.model;

public class AverageData {

    private int hour;
    private String averageTemperature;
    private String averageHumidity;
    private String averageCO2Level;

    public AverageData(int hour, String averageTemperature, String averageHumidity, String averageCO2Level) {
        this.hour = hour;
        this.averageTemperature = averageTemperature;
        this.averageHumidity = averageHumidity;
        this.averageCO2Level = averageCO2Level;
    }

    public AverageData() {
    }

    public int getHour() {
        return hour;
    }

    public String getAverageTemperature() {
        return averageTemperature;
    }

    public String getAverageHumidity() {
        return averageHumidity;
    }

    public String getAverageCO2Level() {
        return averageCO2Level;
    }

}
