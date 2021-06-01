package com.example.sep.model;

public class Humidifier {
    private int id;
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

    public int getState() {
        return state;
    }

    public int getAutomation() {
        return automation;
    }

}
