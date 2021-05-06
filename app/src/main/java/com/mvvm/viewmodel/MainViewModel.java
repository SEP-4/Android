package com.mvvm.viewmodel;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.ViewModel;

import com.mvvm.model.Temperature;
import com.mvvm.repository.TemperatureRepository;

public class MainViewModel extends ViewModel {
    TemperatureRepository repository;

    public MainViewModel() {
        repository = TemperatureRepository.getInstance();
    }

    public LiveData<Temperature> getLastTemperature()
    {
        System.out.println("LiveData<Temperature> getLastTemperature()" +repository.getLastTemperature().getValue());
        return repository.getLastTemperature();
    }

    public void retrieveLastTemperature() {
        repository.retrieveLastTemperature();
    }
}
