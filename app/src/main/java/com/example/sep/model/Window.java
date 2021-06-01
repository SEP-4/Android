package com.example.sep.model;

public class Window {
    private int id;
    private int gymId;
    private int state;
    private String message;
    private int automation;

    public Window(int id, int state, int automation) {
        this.id = id;
        this.state = state;
        this.automation = automation;
    }

    public Window(String message) {
        this.message = message;
    }

    public Window() {
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
