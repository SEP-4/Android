package com.example.sep.data.averageDataService;

import com.example.sep.model.AverageData;
import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;

public interface IAverageDataService {
    @GET("measurement/{date}")
    Call<List<AverageData>> getAverageMeasurement(@Path("date") String date);
}
