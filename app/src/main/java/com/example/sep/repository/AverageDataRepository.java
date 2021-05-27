package com.example.sep.repository;

import android.util.Log;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;

import com.example.sep.data.ServiceGenerator;
import com.example.sep.data.averageDataService.IAverageDataService;
import com.example.sep.model.AverageData;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class AverageDataRepository {
    private static AverageDataRepository instance;
    private MutableLiveData<List<AverageData>> averageDataMutableLiveData;
    //private ArrayList<AverageDataResponse> averageDataArrayList = new ArrayList<>();

    private AverageDataRepository() {
        averageDataMutableLiveData = new MutableLiveData<>();
    }

    public static synchronized AverageDataRepository getInstance() {
        if (instance == null) {
            instance = new AverageDataRepository();
        }
        return instance;
    }

    public LiveData<List<AverageData>> getAverageData(){
        retrieveAverageData();
        return averageDataMutableLiveData;
    }

    public void retrieveAverageData(){
        IAverageDataService service = ServiceGenerator.getAverageData();
        Call<List<AverageData>> call = service.getAverageMeasurement();
        call.enqueue(new Callback<List<AverageData>>() {
            @Override
            public void onResponse(Call<List<AverageData>> call, Response<List<AverageData>> response) {

                ArrayList<AverageData> averageDataArrayList = new ArrayList<>();

                for (AverageData averageData: response.body()) {
                    averageDataArrayList.add( averageData);
                }

                averageDataMutableLiveData.postValue(averageDataArrayList);

            }

            @Override
            public void onFailure(Call<List<AverageData>> call, Throwable t) {
                Log.i("Retrofit", "Something went wrong :(" + t);
            }
        });
    }
}
