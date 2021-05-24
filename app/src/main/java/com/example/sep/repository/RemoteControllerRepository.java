package com.example.sep.repository;

import android.util.Log;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;

import com.example.sep.data.ServiceGenerator;
import com.example.sep.data.remoteControllerService.IRemoteControllerService;
import com.example.sep.data.remoteControllerService.RemoteControllerResponse;
import com.example.sep.model.AC;
import com.example.sep.model.Humidifier;
import com.example.sep.model.Window;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.internal.EverythingIsNonNull;

public class RemoteControllerRepository {
    private static RemoteControllerRepository instance;
    private final MutableLiveData<AC> ac;
    private final MutableLiveData<Window> window;
    private final MutableLiveData<Humidifier> humidifier;

    private RemoteControllerRepository(){
        ac = new MutableLiveData<>();
        window = new MutableLiveData<>();
        humidifier = new MutableLiveData<>();
    }

    public static synchronized RemoteControllerRepository getInstance(){
        if (instance == null){
            instance = new RemoteControllerRepository();
        }
        return instance;
    }



    // -----------AC----------

    public void turnOnAC(){
        IRemoteControllerService remoteControllerService = ServiceGenerator.getRemoteControllerService();
        Call<RemoteControllerResponse> call = remoteControllerService.turnOnAC();


        call.enqueue(new Callback<RemoteControllerResponse>() {
            @EverythingIsNonNull
            @Override
            public void onResponse(Call<RemoteControllerResponse> call, Response<RemoteControllerResponse> response) {
                if (response.isSuccessful()) {
                    response.body().turnOnAC();
                }
            }
            @EverythingIsNonNull
            @Override
            public void onFailure(Call<RemoteControllerResponse> call, Throwable t) {
                Log.i("Retrofit", "Something went wrong :(");
            }
        });
    }

    public void turnOffAC(){
        IRemoteControllerService remoteControllerService = ServiceGenerator.getRemoteControllerService();
        Call<RemoteControllerResponse> call = remoteControllerService.turnOffAC();
        call.enqueue(new Callback<RemoteControllerResponse>() {
            @EverythingIsNonNull
            @Override
            public void onResponse(Call<RemoteControllerResponse> call, Response<RemoteControllerResponse> response) {
                if (response.isSuccessful()) {
                    response.body().turnOffAC();
                }
            }
            @EverythingIsNonNull
            @Override
            public void onFailure(Call<RemoteControllerResponse> call, Throwable t) {
                Log.i("Retrofit", "Something went wrong :(");
            }
        });
    }

    public void getInitialACState(){
        System.out.println("!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!");
        IRemoteControllerService remoteControllerService = ServiceGenerator.getRemoteControllerService();
        Call<RemoteControllerResponse> call = remoteControllerService.getInitialStateAC();
        call.enqueue(new Callback<RemoteControllerResponse>() {
            @EverythingIsNonNull
            @Override
            public void onResponse(Call<RemoteControllerResponse> call, Response<RemoteControllerResponse> response) {
                if (response.isSuccessful()) {
                    ac.setValue(response.body().getACState());
                    System.out.println("Repo:"+ac.toString());
                }
            }
            @EverythingIsNonNull
            @Override
            public void onFailure(Call<RemoteControllerResponse> call, Throwable t) {
                Log.i("Retrofit_AC", "Something went wrong :("+t.getMessage());
            }
        });
    }

    public LiveData<AC> getACState() {
        return ac;
    }



    // -----------Window----------

    public void openWindow(){
        IRemoteControllerService remoteControllerService = ServiceGenerator.getRemoteControllerService();
        Call<RemoteControllerResponse> call = remoteControllerService.openWindow();


        call.enqueue(new Callback<RemoteControllerResponse>() {
            @EverythingIsNonNull
            @Override
            public void onResponse(Call<RemoteControllerResponse> call, Response<RemoteControllerResponse> response) {
                if (response.isSuccessful()) {
                    response.body().openWindow();
                }
            }
            @EverythingIsNonNull
            @Override
            public void onFailure(Call<RemoteControllerResponse> call, Throwable t) {
                Log.i("Retrofit", "Something went wrong :(");
            }
        });
    }

    public void closeWindow(){
        IRemoteControllerService remoteControllerService = ServiceGenerator.getRemoteControllerService();
        Call<RemoteControllerResponse> call = remoteControllerService.closeWindow();
        call.enqueue(new Callback<RemoteControllerResponse>() {
            @EverythingIsNonNull
            @Override
            public void onResponse(Call<RemoteControllerResponse> call, Response<RemoteControllerResponse> response) {
                if (response.isSuccessful()) {
                    response.body().closeWindow();
                }
            }
            @EverythingIsNonNull
            @Override
            public void onFailure(Call<RemoteControllerResponse> call, Throwable t) {
                Log.i("Retrofit", "Something went wrong :(");
            }
        });
    }

    public void getInitialWindowState(){
        IRemoteControllerService remoteControllerService = ServiceGenerator.getRemoteControllerService();
        Call<RemoteControllerResponse> call = remoteControllerService.getInitialStateWindow();
        call.enqueue(new Callback<RemoteControllerResponse>() {
            @EverythingIsNonNull
            @Override
            public void onResponse(Call<RemoteControllerResponse> call, Response<RemoteControllerResponse> response) {
                if (response.isSuccessful()) {
                    window.setValue(response.body().getWindowState());
                }
            }
            @EverythingIsNonNull
            @Override
            public void onFailure(Call<RemoteControllerResponse> call, Throwable t) {
                Log.i("Retrofit_AC", "Something went wrong :("+t.getMessage());
            }
        });
    }

    public LiveData<Window> getWindowState() {
        return window;
    }


    // -----------Humidifier----------

    public void turnOnHumidifier(){
        IRemoteControllerService remoteControllerService = ServiceGenerator.getRemoteControllerService();
        Call<RemoteControllerResponse> call = remoteControllerService.turnOnHumidifier();


        call.enqueue(new Callback<RemoteControllerResponse>() {
            @EverythingIsNonNull
            @Override
            public void onResponse(Call<RemoteControllerResponse> call, Response<RemoteControllerResponse> response) {
                if (response.isSuccessful()) {
                    response.body().turnOnHumidifier();
                }
            }
            @EverythingIsNonNull
            @Override
            public void onFailure(Call<RemoteControllerResponse> call, Throwable t) {
                Log.i("Retrofit", "Something went wrong :(");
            }
        });
    }

    public void turnOffHumidifier(){
        IRemoteControllerService remoteControllerService = ServiceGenerator.getRemoteControllerService();
        Call<RemoteControllerResponse> call = remoteControllerService.turnOffHumidifier();
        call.enqueue(new Callback<RemoteControllerResponse>() {
            @EverythingIsNonNull
            @Override
            public void onResponse(Call<RemoteControllerResponse> call, Response<RemoteControllerResponse> response) {
                if (response.isSuccessful()) {
                    response.body().turnOffHumidifier();
                }
            }
            @EverythingIsNonNull
            @Override
            public void onFailure(Call<RemoteControllerResponse> call, Throwable t) {
                Log.i("Retrofit", "Something went wrong :(");
            }
        });
    }

    public void getInitialHumidifierState(){
        IRemoteControllerService remoteControllerService = ServiceGenerator.getRemoteControllerService();
        Call<RemoteControllerResponse> call = remoteControllerService.getInitialStateHumidifier();
        call.enqueue(new Callback<RemoteControllerResponse>() {
            @EverythingIsNonNull
            @Override
            public void onResponse(Call<RemoteControllerResponse> call, Response<RemoteControllerResponse> response) {
                if (response.isSuccessful()) {
                    humidifier.setValue(response.body().getHumidifierState());
                }
            }
            @EverythingIsNonNull
            @Override
            public void onFailure(Call<RemoteControllerResponse> call, Throwable t) {
                Log.i("Retrofit_AC", "Something went wrong :("+t.getMessage());
            }
        });
    }

    public LiveData<Humidifier> getHumidifierState() {
        return humidifier;
    }
}
