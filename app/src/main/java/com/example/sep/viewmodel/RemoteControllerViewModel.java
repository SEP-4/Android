package com.example.sep.viewmodel;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.ViewModel;

import com.example.sep.model.AC;
import com.example.sep.model.Humidifier;
import com.example.sep.model.Window;
import com.example.sep.repository.RemoteControllerRepository;

public class RemoteControllerViewModel extends ViewModel {

    private RemoteControllerRepository repository;

    public RemoteControllerViewModel() {
        repository = RemoteControllerRepository.getInstance();
    }

    public LiveData<AC> getACState(){
        return repository.getACState();
    }

    public void retrieveLastState(){
        repository.getInitialACState();
    }

    public void turnOnAC(){
        repository.turnOnAC();
    }

    public void turnOffAC(){
        repository.turnOffAC();
    }

    public void turnOnAutomationAC(){
        repository.turnOnAutomationAC();
    }

    public void turnOffAutomationAC(){
        repository.turnOffAutomationAC();
    }

    //Window
    public LiveData<Window> getWindowState(){
        return repository.getWindowState();
    }

    public void retrieveLastStateWindow(){
        repository.getInitialWindowState();
    }

    public void openWindow(){
        repository.openWindow();
    }

    public void closeWindow(){
        repository.closeWindow();
    }

    public void openWindowAutomation(){
        repository.openWindowAutomation();
    }

    public void closeWindowAutomation(){
        repository.closeWindowAutomation();
    }

    //Humidifier
    public LiveData<Humidifier> getHumidifierState(){
        return repository.getHumidifierState();
    }

    public void retrieveLastStateHumidifier(){
        repository.getInitialHumidifierState();
    }

    public void turnOnHumidifier(){
        repository.turnOnHumidifier();
    }

    public void turnOffHumidifier(){
        repository.turnOffHumidifier();
    }

    public void turnOnAutomationHumidifier(){
        repository.turnOnAutomationHumidifier();
    }

    public void turnOffAutomationHumidifier(){
        repository.turnOffAutomationHumidifier();
    }
}