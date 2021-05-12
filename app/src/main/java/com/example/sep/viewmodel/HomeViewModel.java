package com.example.sep.viewmodel;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.ViewModel;

import com.example.sep.model.Measurement;
import com.example.sep.repository.MeasurementRepository;

public class HomeViewModel extends ViewModel {
    MeasurementRepository repository;

    public HomeViewModel() {
        repository = MeasurementRepository.getInstance();
    }

    public LiveData<Measurement> getLastTemperature()
    {
        return repository.getLastMeasurement();
    }

    public void retrieveLastTemperature() {
        repository.retrieveLastMeasurement();
    }
}
