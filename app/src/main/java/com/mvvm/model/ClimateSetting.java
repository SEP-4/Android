package com.mvvm.model;

public class ClimateSetting {
    private int id;
    private double maxTemperature;
    private double minTemperature;
    private double maxCO2;
    private double minCO2;
    private double maxHumidity;
    private double minHumidity;

    public ClimateSetting() {
    }

    public ClimateSetting(int id, double maxTemperature, double minTemperature, double maxCO2, double minCO2, double maxHumidity, double minHumidity) {
        this.id = id;
        this.maxTemperature = maxTemperature;
        this.minTemperature = minTemperature;
        this.maxCO2 = maxCO2;
        this.minCO2 = minCO2;
        this.maxHumidity = maxHumidity;
        this.minHumidity = minHumidity;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public double getMaxTemperature() {
        return maxTemperature;
    }

    public void setMaxTemperature(double maxTemperature) {
        this.maxTemperature = maxTemperature;
    }

    public double getMinTemperature() {
        return minTemperature;
    }

    public void setMinTemperature(double minTemperature) {
        this.minTemperature = minTemperature;
    }

    public double getMaxCO2() {
        return maxCO2;
    }

    public void setMaxCO2(double maxCO2) {
        this.maxCO2 = maxCO2;
    }

    public double getMinCO2() {
        return minCO2;
    }

    public void setMinCO2(double minCO2) {
        this.minCO2 = minCO2;
    }

    public double getMaxHumidity() {
        return maxHumidity;
    }

    public void setMaxHumidity(double maxHumidity) {
        this.maxHumidity = maxHumidity;
    }

    public double getMinHumidity() {
        return minHumidity;
    }

    public void setMinHumidity(double minHumidity) {
        this.minHumidity = minHumidity;
    }
}
