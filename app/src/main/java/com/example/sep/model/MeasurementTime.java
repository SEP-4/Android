package com.example.sep.model;

public class MeasurementTime {
    private int measurement_ID;
    private int gym_ID;
    private double temperature;
    private double humidity;
    private double cO2Level;
    private String date;
    private Long time;

    public MeasurementTime(int measurement_ID, int gym_ID, double temperature, double humidity, double cO2Level, String date, Long time) {
        this.measurement_ID = measurement_ID;
        this.gym_ID = gym_ID;
        this.temperature = temperature;
        this.humidity = humidity;
        this.cO2Level = cO2Level;
        this.date = date;
        this.time = time;
    }


    public int getMeasurement_ID() {
        return measurement_ID;
    }

    public void setMeasurement_ID(int measurement_ID) {
        this.measurement_ID = measurement_ID;
    }

    public int getGym_ID() {
        return gym_ID;
    }

    public void setGym_ID(int gym_ID) {
        this.gym_ID = gym_ID;
    }

    public double getTemperature() {
        return temperature;
    }

    public void setTemperature(double temperature) {
        this.temperature = temperature;
    }

    public double getHumidity() {
        return humidity;
    }

    public void setHumidity(double humidity) {
        this.humidity = humidity;
    }

    public double getcO2Level() {
        return cO2Level;
    }

    public void setcO2Level(double cO2Level) {
        this.cO2Level = cO2Level;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public Long getTime() {
        return time;
    }

    public void setTime(Long time) {
        this.time = time;
    }
}