package com.example.sep.viewmodel;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.ViewModel;

import com.example.sep.model.Gym;
import com.example.sep.repository.GymRepository;

import java.util.List;

public class LoginViewModel extends ViewModel {
    GymRepository gymRepository;

    public LoginViewModel() {
        gymRepository = GymRepository.getInstance();
    }

    public LiveData<Gym> getGymsByEmail(){
        return gymRepository.getGymsByEmail();
    }

    public void retrieveGymsByEmail(String email){
        gymRepository.retrieveGymsByEmail(email);
    }
}
