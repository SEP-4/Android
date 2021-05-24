package com.example.sep.model;

public class Dehumidifier {
    private int id;
    private int gymId;
    private int state;
    private String message;

    public Dehumidifier(int id, int gymId, int state) {
        this.id = id;
        this.gymId = gymId;
        this.state = state;
    }

    public Dehumidifier(int id, int state) {
        this.id = id;
        this.state = state;
    }

    public Dehumidifier(String message) {
        this.message = message;
    }

    public Dehumidifier() {
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
