package com.example.sep.model;

public class Humidifier {
    private int id;
    private int gymId;
    private int state;
    private String message;

    public Humidifier() {
    }

    public Humidifier(int id, int gymId, int state) {
        this.id = id;
        this.gymId = gymId;
        this.state = state;
    }

    public Humidifier(int id, int state) {
        this.id = id;
        this.state = state;
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
}
