package com.mvvm.repository;

import android.util.Log;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;

import com.mvvm.data.ServiceGenerator;
import com.mvvm.data.employeesService.IEmployeesService;
import com.mvvm.data.temperatureService.ITemperatureService;
import com.mvvm.model.Employee;
import com.mvvm.model.Temperature;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.internal.EverythingIsNonNull;

public class EmployeesRepository {
    private static EmployeesRepository instance;
    private final MutableLiveData<List<Employee>> getEmployees;

    private EmployeesRepository() {
        getEmployees = new MutableLiveData<>();
    }

    public static synchronized EmployeesRepository getInstance() {
        if (instance == null) {
            instance = new EmployeesRepository();
        }
        return instance;
    }

    public LiveData<List<Employee>> getEmployeesByName() {
        return getEmployees;
    }
    public void retrieveEmployeesByName(String name) {
        IEmployeesService employeesService = ServiceGenerator.getEmployeesService();
        Call<List<Employee>> call = employeesService.getEmployeesByName(name);
        call.enqueue(new Callback<List<Employee>>() {
            @EverythingIsNonNull
            @Override
            public void onResponse(Call<List<Employee>> call, Response<List<Employee>> response) {
                if (response.isSuccessful()) {
                    List<Employee> temp=new ArrayList<Employee>();
                    for (int i = 0; i < response.body().size(); i++) {
                        temp.add(response.body().get(i));
                    }

                    getEmployees.setValue(temp);
                }
            }
            @EverythingIsNonNull
            @Override
            public void onFailure(Call<List<Employee>> call, Throwable t) {
                Log.i("Retrofit", "Something went wrong :(");
            }
        });
    }
}
