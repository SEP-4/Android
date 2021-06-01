package com.example.sep.repository;

import android.util.Log;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;

import com.example.sep.data.ServiceGenerator;
import com.example.sep.data.measurementService.IMeasurementService;
import com.example.sep.data.measurementService.MeasurementResponse;
import com.example.sep.model.Measurement;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.internal.EverythingIsNonNull;

public class MeasurementRepository {
    private static MeasurementRepository instance;
    private final MutableLiveData<Measurement> lastMeasurement;

    private MeasurementRepository() {
        lastMeasurement = new MutableLiveData<>();
    }

    public static synchronized MeasurementRepository getInstance() {
        if (instance == null) {
            instance = new MeasurementRepository();
        }
        return instance;
    }

    public LiveData<Measurement> getLastMeasurement() {
        retrieveLastMeasurement();
        return lastMeasurement;
    }
    public void retrieveLastMeasurement() {
        IMeasurementService temperatureService = ServiceGenerator.getMeasurementService();
        Call<MeasurementResponse> call = temperatureService.getLastMeasurement();
        call.enqueue(new Callback<MeasurementResponse>() {
            @EverythingIsNonNull
            @Override
            public void onResponse(Call<MeasurementResponse> call, Response<MeasurementResponse> response) {
                if (response.isSuccessful()) {
                    Log.i("Retrofit: " , " " +response.body().getMeasurement());
                    lastMeasurement.setValue(response.body().getMeasurement());
                }
            }

            @EverythingIsNonNull
            @Override
            public void onFailure(Call<MeasurementResponse> call, Throwable t) {
                Log.i("Retrofit", "Something went wrong :(" + t);
            }
        });
    }
}


