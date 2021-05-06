package com.mvvm.data.temperatureService;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.mvvm.model.Temperature;

import java.sql.Time;
import java.util.Date;

public class TemperatureResponse {
    @JsonProperty("temperature_ID")
    private  int temperature_ID;
    @JsonProperty("Temperature")
    private  double Temperature;
    @JsonProperty("date")
    private  Date date;
    @JsonProperty("time")
    private  Time time;
    @JsonProperty("gym_ID")
    private  int gym_ID;

    public Temperature getTemperature(){
        return new Temperature(temperature_ID, gym_ID, Temperature, date, time);
    }
}
