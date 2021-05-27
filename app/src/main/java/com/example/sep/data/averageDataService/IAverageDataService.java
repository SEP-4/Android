package com.example.sep.data.averageDataService;

import com.example.sep.data.measurementService.MeasurementResponse;
import com.example.sep.model.AverageData;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;

public interface IAverageDataService {
    @GET("measurement/2021-05-24")
    Call<List<AverageData>> getAverageMeasurement();
}
