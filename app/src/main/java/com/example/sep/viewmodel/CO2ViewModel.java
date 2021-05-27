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


    private LiveData<List<AverageData>> listMutableLiveData;


    public LiveData<List<AverageData>> getAverageData(){

        return listMutableLiveData;
    }

    public void retrieveAverageData(){

        listMutableLiveData = AverageDataRepository.getInstance().getAverageData();

    }
}