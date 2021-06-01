package com.example.sep.viewmodel;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.ViewModel;

import com.example.sep.model.Measurement;
import com.example.sep.repository.MeasurementRepository;

public class HomeViewModel extends ViewModel {
    private MeasurementRepository repository;

    private LiveData<Measurement> measurementLiveData;

    public HomeViewModel() {
        repository = MeasurementRepository.getInstance();
    }

    public LiveData<Measurement> getLastTemperature()
    {
        return measurementLiveData;
    }

    public void retrieveLastTemperature() {
        measurementLiveData = MeasurementRepository.getInstance().getLastMeasurement();
    }
}


