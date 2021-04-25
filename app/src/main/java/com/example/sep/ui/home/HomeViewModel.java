package com.example.sep.ui.home;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.example.sep.R;
import com.mvvm.model.Temperature;
import com.mvvm.repository.TemperatureRepository;

import java.util.ArrayList;

public class HomeViewModel extends ViewModel {

    private MutableLiveData<String> mText;
    private MutableLiveData<ArrayList<Info>> mInfo;
    private ArrayList<Info> infos;
    private final TemperatureRepository repository;

    public HomeViewModel() {
        mText = new MutableLiveData<>();
        mInfo = new MutableLiveData<>();
        repository = TemperatureRepository.getInstance();

        init();
        System.out.println( "tmp" + repository.getLastTemperature());
    }

    public LiveData<String> getText() {
        return mText;
    }

    public LiveData<ArrayList<Info>> getInfoLiveData(){ return mInfo; }

    public void init(){
        populateList();
        mInfo.setValue(infos);
    }
    LiveData<Temperature> getLastTemperature() {
        return repository.getLastTemperature();
    }

    public void retrieveLastTemperature() {
        repository.retrieveLastTemperature();
    }


    public void populateList(){
        infos = new ArrayList<>();
        infos.add(new Info("Temperature","20-22C°", 22, R.drawable.thermostat_icon));
        infos.add(new Info("Humidity","40-60%", 40, R.drawable.humidity_icon));
        infos.add(new Info("CO2","400 - 1000ppm", 900, R.drawable.cloud_co2_icon));
    }
}