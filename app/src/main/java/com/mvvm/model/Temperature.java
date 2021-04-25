package com.mvvm.model;

import java.sql.Time;
import java.util.Date;

public class Temperature {
    private final int id;
    private final double temperature;
    private final Date date;
    private final Time time;
    private final int gymId;

    public Temperature(int id, double temperature, Date date, Time time, int gymId) {
        this.id = id;
        this.temperature = temperature;
        this.date = date;
        this.time = time;
        this.gymId = gymId;
    }
    public Temperature getTemperatureObject(){
        return new Temperature(id,temperature,date,time,gymId);
    }

    public int getId() {
        return id;
    }

    public double getTemperature() {
        return temperature;
    }

    public Date getDate() {
        return date;
    }

    public Time getTime() {
        return time;
    }

    public int getGymId() {
        return gymId;
    }
}
