package com.mvvm.data;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

import com.mvvm.data.employeesService.IEmployeesService;
import com.mvvm.data.temperatureService.ITemperatureService;

public class ServiceGenerator {
    private static IEmployeesService employeesService;
    private static ITemperatureService temperatureService;

    public static IEmployeesService getEmployeesService() {
        if (employeesService == null) {
            employeesService = new Retrofit.Builder()
                    .baseUrl("https://employees.co")
                    .addConverterFactory(GsonConverterFactory.create())
                    .build()
                    .create(IEmployeesService.class);
        }
        return employeesService;
    }
    public static ITemperatureService getTemperatureService() {
        if (temperatureService == null) {
            temperatureService = new Retrofit.Builder()
                    .baseUrl("https://temperature.co")
                    .addConverterFactory(GsonConverterFactory.create())
                    .build()
                    .create(ITemperatureService.class);
        }
        return temperatureService;
    }
}
