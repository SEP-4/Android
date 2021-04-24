package com.mvvm.model;

import java.sql.Time;
import java.util.Date;

public class CO2 {
    private int id;
    private double co2Level;
    private Date date;
    private Time time;
    private int gymId;

    public CO2() {
    }

    public CO2(int id, double co2Level, Date date, Time time, int gymId) {
        this.id = id;
        this.co2Level = co2Level;
        this.date = date;
        this.time = time;
        this.gymId = gymId;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public double getCo2Level() {
        return co2Level;
    }

    public void setCo2Level(double co2Level) {
        this.co2Level = co2Level;
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
