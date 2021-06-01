package com.example.sep.data.measurementService;

import retrofit2.Call;
import retrofit2.http.GET;

public interface IMeasurementService {
    @GET("measurement")
    Call<MeasurementResponse> getLastMeasurement();
}



