package com.mvvm.viewmodel;

import androidx.lifecycle.LiveData;

import com.mvvm.model.Temperature;
import com.mvvm.repository.TemperatureRepository;

public class MainViewModel {
    TemperatureRepository repository;

    public MainViewModel() {
        repository = TemperatureRepository.getInstance();
    }

    LiveData<Temperature> getLastTemperature() {
        return repository.getLastTemperature();
    }

    public void retrieveLastTemperature() {
        repository.retrieveLastTemperature();
    }
}
