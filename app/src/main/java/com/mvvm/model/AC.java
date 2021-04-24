package com.mvvm.model;

public class AC {
    private int id;
    private int gymId;
    private int state;
    private double targetTemperature;

    public AC(int id, int gymId, int state, double targetTemperature) {
        this.id = id;
        this.gymId = gymId;
        this.state = state;
        this.targetTemperature = targetTemperature;
    }

    public AC() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getGymId() {
        return gymId;
    }

    public void setGymId(int gymId) {
        this.gymId = gymId;
    }

    public int getState() {
        return state;
    }

    public void setState(int state) {
        this.state = state;
    }

    public double getTargetTemperature() {
        return targetTemperature;
    }

    public void setTargetTemperature(double targetTemperature) {
        this.targetTemperature = targetTemperature;
    }
}
