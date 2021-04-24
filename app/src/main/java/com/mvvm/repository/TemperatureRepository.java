package com.mvvm.repository;

import android.util.Log;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;

import com.mvvm.data.ServiceGenerator;
import com.mvvm.data.temperatureService.ITemperatureService;
import com.mvvm.model.Temperature;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.internal.EverythingIsNonNull;

public class TemperatureRepository {
    private static TemperatureRepository instance;
    private final MutableLiveData<Temperature> lastTemperature;

    private TemperatureRepository() {
        lastTemperature = new MutableLiveData<>();
    }

    public static synchronized TemperatureRepository getInstance() {
        if (instance == null) {
            instance = new TemperatureRepository();
        }
        return instance;
    }

    public LiveData<Temperature> getLastTemperature() {
        return lastTemperature;
    }
    public void retrieveLastTemperature() {
        ITemperatureService temperatureService = ServiceGenerator.getTemperatureService();
        Call<Temperature> call = temperatureService.getLastTemperature();
        call.enqueue(new Callback<Temperature>() {
            @EverythingIsNonNull
            @Override
            public void onResponse(Call<Temperature> call, Response<Temperature> response) {
                if (response.isSuccessful()) {
                    lastTemperature.setValue(response.body().getTemperatureObject());
                }
            }
            @EverythingIsNonNull
            @Override
            public void onFailure(Call<Temperature> call, Throwable t) {
                Log.i("Retrofit", "Something went wrong :(");
            }
        });
    }
}
