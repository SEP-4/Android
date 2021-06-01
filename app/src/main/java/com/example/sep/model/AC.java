package com.example.sep.model;

public class AC {
    private int id;
    private int gymId;
    private int state;
    private double targetTemperature;
    private String message;
    private int automation;


    public AC(int id, int state, double targetTemperature, int automation) {
        this.id = id;
        this.state = state;
        this.targetTemperature = targetTemperature;
        this.automation = automation;
    }

    public AC(String message) {
        this.message = message;
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

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public void setTargetTemperature(double targetTemperature) {
        this.targetTemperature = targetTemperature;
    }

    public int getAutomation() {
        return automation;
    }

    public void setAutomation(int automation) {
        this.automation = automation;
    }
}
