package com.mvvm.model;

public class Humidifier {
    private int id;
    private int gymId;
    private int state;

    public Humidifier() {
    }

    public Humidifier(int id, int gymId, int state) {
        this.id = id;
        this.gymId = gymId;
        this.state = state;
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
}
