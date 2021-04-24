package com.mvvm.model;

import java.sql.Time;
import java.util.Date;

public class Humidity {
    private int id;
    private double percentage;
    private Date date;
    private Time time;
    private int gymId;

    public Humidity() {
    }

    public Humidity(int id, double percentage, Date date, Time time, int gymId) {
        this.id = id;
        this.percentage = percentage;
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

    public double getPercentage() {
        return percentage;
    }

    public void setPercentage(double percentage) {
        this.percentage = percentage;
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
