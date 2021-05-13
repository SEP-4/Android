package com.example.sep.repository;
import android.util.Log;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;

import com.example.sep.data.ServiceGenerator;
import com.example.sep.data.gymService.GymResponse;
import com.example.sep.data.gymService.IGymService;
import com.example.sep.model.Employee;
import com.example.sep.model.Gym;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.internal.EverythingIsNonNull;

public class GymRepository {
    private static GymRepository instance;
    private final MutableLiveData<Gym> gym;

    private GymRepository() {
        gym = new MutableLiveData<>();
    }

    public static synchronized GymRepository getInstance() {
        if (instance == null) {
            instance = new GymRepository();
        }
        return instance;
    }

    public LiveData<Gym> getGymsByEmail() {
        return gym;
    }

    public void retrieveGymsByEmail(String email) {
        IGymService gymService = ServiceGenerator.getGymsService();
        Call<GymResponse> call = gymService.getGymsByEmail(email);
        call.enqueue(new Callback<GymResponse>() {
            @EverythingIsNonNull
            @Override
            public void onResponse(Call<GymResponse> call, Response<GymResponse> response) {
                if (response.isSuccessful()) {
//                    List<Gym> temp=new ArrayList<Gym>();
//                    for (int i = 0; i < response.body().size(); i++) {
//                        temp.add(response.body().get(i));
//                    }

                    gym.setValue(response.body().getGym());
                }
            }
            @EverythingIsNonNull
            @Override
            public void onFailure(Call<GymResponse> call, Throwable t) {
                Log.i("Retrofit", "Something went wrong :(");
            }
        });
    }
}
