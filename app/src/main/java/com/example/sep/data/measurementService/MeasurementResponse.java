package com.example.sep.data.measurementService;
import com.example.sep.model.Measurement;
import com.example.sep.model.MeasurementTime;

import java.sql.Time;

public class MeasurementResponse {
    private int measurement_ID;
    private int gym_ID;
    private double temperature;
    private double humidity;
    private double cO2Level;
    private String date;
    private Long time;


    public Measurement getMeasurement(){
        MeasurementTime measurementTime = new MeasurementTime(measurement_ID,gym_ID,temperature, humidity, cO2Level, date, time);
        System.out.println("Response temp: "+new Measurement(measurement_ID, gym_ID, temperature, humidity, cO2Level, date, new Time(measurementTime.getTime())));
        return new Measurement(measurement_ID, gym_ID, temperature, humidity, cO2Level, date, new Time(measurementTime.getTime()));
    }
}
