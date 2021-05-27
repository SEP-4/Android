package com.example.sep.viewmodel;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.example.sep.model.AverageData;
import com.example.sep.repository.AverageDataRepository;

import java.util.ArrayList;
import java.util.List;

public class CO2ViewModel extends ViewModel {
    private AverageDataRepository repository;

    public CO2ViewModel() {
        repository = AverageDataRepository.getInstance();
    }

    public LiveData<List<AverageData>> getAverageData(){
        return repository.getAverageData();
    }

    public void retrieveAverageData(){
        repository.retrieveAverageData();
    }
}