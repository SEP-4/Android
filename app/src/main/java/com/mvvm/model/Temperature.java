package com.mvvm.model;

import java.sql.Time;
import java.util.Date;

import retrofit2.http.POST;

public class Temperature {
    private int id;
    private double temperature;
    private Date date;
    private Time time;
    private int gymId;

    public Temperature() {

    }

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

    public void setId(int id) {
        this.id = id;
    }

    public double getTemperature() {
        return temperature;
    }

    public void setTemperature(double temperature) {
        this.temperature = temperature;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public Time getTime() {
        return time;
    }

    public void setTime(Time time) {
        this.time = time;
    }

    public int getGymId() {
        return gymId;
    }

    public void setGymId(int gymId) {
        this.gymId = gymId;
    }
}
