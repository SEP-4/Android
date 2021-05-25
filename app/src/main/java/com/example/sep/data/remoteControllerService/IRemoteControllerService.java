package com.example.sep.data.remoteControllerService;

import com.example.sep.data.measurementService.MeasurementResponse;

import retrofit2.Call;
import retrofit2.http.GET;

public interface IRemoteControllerService {
    @GET("AC/turnOff/1")
    Call<RemoteControllerResponse> turnOffAC();

    @GET("AC/turnOn/1")
    Call<RemoteControllerResponse> turnOnAC();

    @GET("AC/turnOnAutomation/1")
    Call<RemoteControllerResponse> turnAutomationOnAC();

    @GET("AC/turnOffAutomation/1")
    Call<RemoteControllerResponse> turnAutomationOffAC();

    @GET("AC/1")
    Call<RemoteControllerResponse> getInitialStateAC();

    //Window
    @GET("Window/turnOff/1")
    Call<RemoteControllerResponse> closeWindow();

    @GET("Window/turnOn/1")
    Call<RemoteControllerResponse> openWindow();

    @GET("Window/turnOnAutomation/1")
    Call<RemoteControllerResponse> openWindowAutomation();

    @GET("Window/turnOffAutomation/1")
    Call<RemoteControllerResponse> closeWindowAutomation();

    @GET("Window/1")
    Call<RemoteControllerResponse> getInitialStateWindow();

    //Humidifier
    @GET("Humidifier/turnOff/1")
    Call<RemoteControllerResponse> turnOffHumidifier();

    @GET("Humidifier/turnOn/1")
    Call<RemoteControllerResponse> turnOnHumidifier();

    @GET("Humidifier/turnOnAutomation/1")
    Call<RemoteControllerResponse> turnOnAutomationHumidifier();

    @GET("Humidifier/turnOffAutomation/1")
    Call<RemoteControllerResponse> turnOffAutomationHumidifier();

    @GET("Humidifier/1")
    Call<RemoteControllerResponse> getInitialStateHumidifier();
}
