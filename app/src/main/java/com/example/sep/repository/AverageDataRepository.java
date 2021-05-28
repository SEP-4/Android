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


    private List<AverageData> averageDataList = new ArrayList<>();

    private AverageDataRepository() {
        averageDataMutableLiveData = new MutableLiveData<>();
    }

    public static synchronized AverageDataRepository getInstance() {
        if (instance == null) {
            instance = new AverageDataRepository();
        }
        return instance;
    }


    public LiveData<List<AverageData>> getAverageData(String date){
        averageDataList.clear();
        retrieveAverageData(date);
        averageDataMutableLiveData.setValue(averageDataList);
        return averageDataMutableLiveData;
    }

    public void retrieveAverageData(String date){
        IAverageDataService service = ServiceGenerator.getAverageData();
        Call<List<AverageData>> call = service.getAverageMeasurement(date);
        call.enqueue(new Callback<List<AverageData>>() {
            @Override
            public void onResponse(Call<List<AverageData>> call, Response<List<AverageData>> response) {

                averageDataList = new ArrayList<>();

                averageDataList.addAll(response.body());


                averageDataMutableLiveData.postValue(averageDataList);
            }

            @Override
            public void onFailure(Call<List<AverageData>> call, Throwable t) {
                Log.i("Retrofit", "Something went wrong :(" + t);
            }
        });
    }
}
