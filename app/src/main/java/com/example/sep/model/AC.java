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

    public int getState() {
        return state;
    }

    public int getAutomation() {
        return automation;
    }

}
