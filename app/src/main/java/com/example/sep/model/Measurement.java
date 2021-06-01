package com.example.sep.model;

import java.sql.Time;

public class Measurement {
    private int measurement_ID;
    private int gym_ID;
    private double temperature;
    private double humidity;
    private double cO2Level;
    private String date;
    private Time time;
    private boolean isExpandable;
    private int imageId;

    public Measurement(int measurement_ID, int gym_ID, double temperature, double humidity, double cO2Level, String date, Time time) {
        this.measurement_ID = measurement_ID;
        this.gym_ID = gym_ID;
        this.temperature = temperature;
        this.humidity = humidity;
        this.cO2Level = cO2Level;
        this.date = date;
        this.time = time;
    }

    public Measurement() {
    }

    public double getTemperature() {
        return temperature;
    }


    public double getHumidity() {
        return humidity;
    }

    public double getcO2Level() {
        return cO2Level;
    }


}
