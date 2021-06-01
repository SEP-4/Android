package com.example.sep.model;

public class Humidifier {
    private int id;
    private int gymId;
    private int state;
    private String message;
    private int automation;

    public Humidifier() {
    }

    public Humidifier(int id, int state, int automation) {
        this.id = id;
        this.state = state;
        this.automation = automation;
    }

    public Humidifier(String message) {
        this.message = message;
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

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public int getAutomation() {
        return automation;
    }

    public void setAutomation(int automation) {
        this.automation = automation;
    }
}
