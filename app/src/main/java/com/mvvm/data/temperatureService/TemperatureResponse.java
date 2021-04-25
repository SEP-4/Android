package com.mvvm.data.temperatureService;

import com.mvvm.model.Temperature;

import java.sql.Time;
import java.util.Date;

public class TemperatureResponse {
    private  int id;
    private  double Temperature;
    private  Date date;
    private  Time time;
    private  int gymId;

    public Temperature getTemperature(){
        return new Temperature(id, Temperature, date, time, gymId);
    }
}
