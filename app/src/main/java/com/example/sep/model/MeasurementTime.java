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

    public Long getTime() {
        return time;
    }
}
