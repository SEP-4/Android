package com.mvvm.data.temperatureService;

import com.mvvm.model.Temperature;

import retrofit2.Call;
import retrofit2.http.GET;

public interface ITemperatureService {
    @GET("measurement")
    Call<TemperatureResponse> getLastTemperature();
}
