package com.example.sep.model;

public class AverageData {

    int hour;
    String averageTemperature;
    String averageHumidity;
    String averageCO2Level;

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

    public void setHour(int hour) {
        this.hour = hour;
    }

    public String getAverageTemperature() {
        return averageTemperature;
    }

    public void setAverageTemperature(String averageTemperature) {
        this.averageTemperature = averageTemperature;
    }

    public String getAverageHumidity() {
        return averageHumidity;
    }

    public void setAverageHumidity(String averageHumidity) {
        this.averageHumidity = averageHumidity;
    }

    public String getAverageCO2Level() {
        return averageCO2Level;
    }

    public void setAverageCO2Level(String averageCO2Level) {
        this.averageCO2Level = averageCO2Level;
    }
}
